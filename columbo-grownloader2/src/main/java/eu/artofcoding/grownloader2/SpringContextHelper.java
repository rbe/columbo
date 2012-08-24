package eu.artofcoding.grownloader2;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class SpringContextHelper implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(SpringContextHelper.class);

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * http://forum.springsource.org/showthread.php?125695-Orderly-shutdown-how-to-know-when-downstream-executor-is-idle
     *
     * @param shutdownForced
     */
    public void stopSchedulers(boolean shutdownForced) {
        logger.info("Stopping schedulers " + (shutdownForced ? "(force)" : ""));
        List<ExecutorService> executorServices = new ArrayList<ExecutorService>();
        Map<String, ThreadPoolTaskScheduler> schedulers = applicationContext.getBeansOfType(ThreadPoolTaskScheduler.class);
        for (Map.Entry<String, ThreadPoolTaskScheduler> entry : schedulers.entrySet()) {
            ThreadPoolTaskScheduler scheduler = entry.getValue();
            logger.info("Stopping scheduler " + scheduler.getThreadNamePrefix());
            ExecutorService executorService = scheduler.getScheduledExecutor();
            executorServices.add(executorService);
            if (shutdownForced) {
                executorService.shutdownNow();
            } else {
                executorService.shutdown();
            }
        }
        waitForExecutors(executorServices);
        logger.info("Stopped schedulers");
    }

    private void waitForExecutors(List<ExecutorService> executorServices) {
        long shutdownDeadline = System.currentTimeMillis() + 1000;
        for (ExecutorService executorService : executorServices) {
            try {
                if (!executorService.awaitTermination(shutdownDeadline - System.currentTimeMillis(), TimeUnit.MILLISECONDS)) {
                    logger.info("Executor service " + executorService + " failed to terminate");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.warn("Interrupted while shutting down executor service " + executorService);
                throw new RuntimeException("Interrupted while shutting down", e);
            }
            if (System.currentTimeMillis() > shutdownDeadline) {
                logger.warn("Timed out before waiting for all executor services");
            }
        }
    }

    private void stopExecutors() {
        ThreadPoolTaskExecutor springTaskExecutor = applicationContext.getBean("taskExecutor", ThreadPoolTaskExecutor.class);
        ThreadPoolExecutor springExecutor = springTaskExecutor.getThreadPoolExecutor();
        springExecutor.shutdownNow();
        Map<String, ThreadPoolTaskExecutor> map = applicationContext.getBeansOfType(ThreadPoolTaskExecutor.class);
        ThreadPoolTaskExecutor t = null;
        for (String key : map.keySet()) {
            t = map.get(key);
            final ThreadPoolExecutor executor = t.getThreadPoolExecutor();
            executor.shutdownNow();
            logger.info(executor.toString() + ": active after shutdown: " + executor.getActiveCount());
            logger.info(executor.toString() + ": completed after shutdown: " + executor.getCompletedTaskCount());
        }
    }

    private void closeDataSources() {
        Map<String, BasicDataSource> map2 = applicationContext.getBeansOfType(BasicDataSource.class);
        for (String key : map2.keySet()) {
            BasicDataSource dataSource = map2.get(key);
            try {
                dataSource.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdownDueToException(Throwable throwable) {
        logger.error("Stopping system due to exception: " + throwable);
        /*
        closeDataSources();
        stopExecutors();
        */
        Grownloader.shutdown();
    }

}
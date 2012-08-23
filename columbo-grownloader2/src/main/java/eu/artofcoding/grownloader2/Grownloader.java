package eu.artofcoding.grownloader2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class Grownloader {

    private static final Logger logger = LoggerFactory.getLogger(Grownloader.class); //Logger.getLogger(Grownloader.class.getName());

    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);
    private static final AtomicBoolean COMPLETED = new AtomicBoolean(false);

    public static void shutdown() {
        COMPLETED.getAndSet(true);
        COUNT_DOWN_LATCH.countDown();
    }

    public static void main(String[] args) {
        // Configure and start Spring application context
        final String[] contextXml = new String[]{
                "classpath:META-INF/spring-context.xml",
                "conf/datasources.xml",
                "conf/table1.xml"
        };
        FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext(contextXml);
        // Wait...
        while (!COMPLETED.get()) {
            try {
                COUNT_DOWN_LATCH.await();
            } catch (InterruptedException e) {
                // ignore...
            }
        }
        logger.info("Seems we're finished... stopping Spring application context");
        // Stop Spring
        if (COMPLETED.get()) {
            applicationContext.close();
        }
        logger.info("Bye!");
    }

}

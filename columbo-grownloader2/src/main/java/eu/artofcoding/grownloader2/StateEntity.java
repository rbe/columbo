package eu.artofcoding.grownloader2;

import java.util.Calendar;
import java.util.Date;

public class StateEntity {

    private String tableName;
    private Date lastDownload;
    private Integer downloadHours;
    private Calendar dateFrom;
    private Calendar dateTo;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Date getLastDownload() {
        return lastDownload;
    }

    public void setLastDownload(Date lastDownload) {
        this.lastDownload = lastDownload;
    }

    public Integer getDownloadHours() {
        return downloadHours;
    }

    public void setDownloadHours(Integer downloadHours) {
        this.downloadHours = downloadHours;
    }

    public Calendar getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Calendar dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Calendar getDateTo() {
        return dateTo;
    }

    public void setDateTo(Calendar dateTo) {
        this.dateTo = dateTo;
    }

}

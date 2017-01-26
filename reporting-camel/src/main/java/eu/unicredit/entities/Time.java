package eu.unicredit.entities;

/**
 * Created by c314668 on 19/01/17.
 */
public class Time {
    Long endTime;

    Long meanTime;

    Long startTime;

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public void setMeanTime(Long meanTime) {
        this.meanTime = meanTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Long getMeanTime() {
        return meanTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public String toString() {
        return meanTime.toString();
    }
}

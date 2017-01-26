package entities;

/**
 * Created by c314668 on 19/01/17.
 */
public class RestInfo {
    String url;

    Long time;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return url + time.toString();
    }
}

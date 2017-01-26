package eu.unicredit.entities;

/**
 * Created by c314668 on 19/01/17.
 */
public class RestInfo {
    String category;

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

    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}

    public String toString() {
        return category+","+url+","+time.toString();
    }
}

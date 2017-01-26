package eu.unicredit.entities;

/**
 * Created by c314668 on 19/01/17.
 */
public class PageInfo {
    String category;

    String page;

    Time time;

    String url;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Time getTime() {return time;}

    public void setTime(Time time) {this.time = time;    }

    public String getUrl() {return url;}

    public void setUrl(String url) {this.url = url;}

    public String toString() {
        return category+","+page+","+url+","+time.toString();
    }
}

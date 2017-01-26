package entities;

/**
 * Created by c314668 on 19/01/17.
 */
public class PageInfo {
    String category;

    String page;

    Long meanTime;

    String workflow;

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

    public Long getMeanTime() {
        return meanTime;
    }

    public void setMeanTime(Long meanTime) {
        this.meanTime = meanTime;
    }

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }

    public String toString() {
        return category+","+page+","+meanTime.toString()+","+workflow;
    }
}

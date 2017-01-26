package eu.unicredit.entities;

/**
 * Created by c314668 on 19/01/17.
 */
public class Report {
    Client client;

    PageInfo[] pageInfo;

    RestInfo[] restInfo;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PageInfo[] getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo[] pageInfo) {
        this.pageInfo = pageInfo;
    }

    public RestInfo[] getRestInfo() {
        return restInfo;
    }

    public void setRestInfo(RestInfo[] restInfo) {
        this.restInfo = restInfo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(client.toString()+",");

        sb.append("[");
        for(int i=0; i< pageInfo.length-1; i++)
            sb.append(pageInfo[i].toString()+",");
        sb.append(pageInfo[pageInfo.length-1]);
        sb.append("],");

        sb.append("[");
        for(int i=0; i< restInfo.length-1; i++)
            sb.append(restInfo[i].toString()+",");
        sb.append(restInfo[pageInfo.length-1]);
        sb.append("]");

        return sb.toString();
    }
}
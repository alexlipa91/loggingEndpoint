package eu.unicredit.reporting;

/**
 * Created by c314668 on 19/01/17.
 */

import eu.unicredit.entities.PageInfo;
import eu.unicredit.entities.Report;
import eu.unicredit.entities.RestInfo;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class ReportRest {

    private Logger logger = Logger.getLogger(ReportRest.class);

    @POST
    @Path("/store")
    @Consumes("application/json")
    public Response createProductInJSON(Report report) {
        StringBuilder sb = new StringBuilder();

        PageInfo[] pageInfos = report.getPageInfo();
        for(PageInfo p : pageInfos)
            logger.info("PAGE_INFO "+p.toString());
        sb.append("Stored ").append(pageInfos.length).append(" page analytics\n");

        RestInfo[] restInfos = report.getRestInfo();
        for(RestInfo r : restInfos)
            logger.info("REST_INFO "+r.toString());
        sb.append("Stored ").append(restInfos.length).append(" rest analytics\n");

        return Response.status(200).entity(sb.toString()).build();
    }
}
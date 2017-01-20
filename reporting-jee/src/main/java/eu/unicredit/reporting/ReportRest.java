package eu.unicredit.reporting;

/**
 * Created by c314668 on 19/01/17.
 */

import eu.unicredit.entities.Report;
import org.apache.log4j.Logger;

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
        String result = report.toString();
        logger.info(result);
        return Response.status(201).entity(result).build();
    }
}
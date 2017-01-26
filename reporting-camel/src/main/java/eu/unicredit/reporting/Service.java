package eu.unicredit.reporting;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.unicredit.entities.PageInfo;
import eu.unicredit.entities.Report;
import eu.unicredit.entities.RestInfo;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.apache.camel.main.MainListenerSupport;

public class Service {

    public static final String hostname = "localhost";
    public static final int port = 8080;
    public static final String serviceRoot = "/report/store";

    protected static RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                final ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
                from("jetty:http://"+hostname+":"+port+serviceRoot+"?httpMethodRestrict=POST")
                        .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        String body = exchange.getIn().getBody(String.class);
                        Report report = mapper.readValue(body, Report.class);
                        StringBuilder sb = new StringBuilder();

                        PageInfo[] pageInfos = report.getPageInfo();
                        for(PageInfo p : pageInfos)
                            log.info("PAGE_INFO "+p.toString());
                        sb.append("Stored ").append(pageInfos.length).append(" page analytics\n");

                        RestInfo[] restInfos = report.getRestInfo();
                        for(RestInfo r : restInfos)
                            log.info("REST_INFO "+r.toString());
                        sb.append("Stored ").append(restInfos.length).append(" rest analytics\n");

                        exchange.getOut().setBody(sb.toString());
                    }
                });
            }
        };
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.addMainListener(new MainListenerSupport() {
            public void configure(CamelContext context) {
                try {
                    context.addRoutes(createRouteBuilder());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            main.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
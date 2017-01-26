import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
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
                from("jetty:http://"+hostname+":"+port+serviceRoot+"?httpMethodRestrict=POST")
                        .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        String body = exchange.getIn().getBody(String.class);
                        log.info(body);
                        exchange.getOut().setBody(body);
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
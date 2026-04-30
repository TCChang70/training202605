
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.*;
@Path("/hi")
public class HelloWorldRestService {

    @GET
    @Produces(MediaType.TEXT_HTML + ";charset=UTF-8")
    public String getHelloMessage(){
        return "<h1>Hi 您好!</h1>";
    }
    @GET
    @Path("/mydata")
    @Produces(MediaType.APPLICATION_JSON)
    public MyData create() {
    	   MyData m1=new MyData(1,10);
    	   return m1;
    }
}


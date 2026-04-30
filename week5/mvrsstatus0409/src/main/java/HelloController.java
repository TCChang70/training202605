import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloController {
    
	@GET
	@Produces(MediaType.TEXT_HTML+";charset=utf-8")
	public String greeting() {
		return "<h1>Greetings</h1>";
	}
}

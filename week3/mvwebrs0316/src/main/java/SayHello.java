import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class SayHello {

	@GET
	@Produces(MediaType.TEXT_HTML+";charset=utf-8")
	public String hello() {
		return "Hello World(大家好)";
	}
	
	@GET
	@Path("/{id}")
	public String paramTest(@PathParam("id")int uid) {
		uid++;
		return "Path Parameter:"+uid;
	}
}

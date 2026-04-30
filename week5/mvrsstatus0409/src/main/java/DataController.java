import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/data")
public class DataController {
    
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response received(@FormParam("name")String name,@FormParam("age")int age,
			@FormParam("address")String address) {
		return Response.ok().entity(name+","+age+","+address).build();
	}
	
	@POST
	@Path("/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response receivedJson(Map<String,String> user) {
		return Response.ok().entity(
				user.get("name")+","+user.get("age")+","+user.get("address")).build();
	}
}

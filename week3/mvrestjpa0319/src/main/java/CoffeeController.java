import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;
import java.util.*;

@Path("/coffees")
public class CoffeeController {
   
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCoffees() {
		CoffeeDAO dao=new CoffeeDAO();
		List<Coffee> cofs=dao.getAllCoffees();
		if(cofs==null || cofs.size()==0) {
			return Response.noContent().build();
		}else {
			return Response.ok().entity(cofs).build();
		}
	}
}

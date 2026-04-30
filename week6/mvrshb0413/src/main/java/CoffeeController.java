import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;
import java.util.*;
@Path("/coffees")
public class CoffeeController {
	
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAllCoffees() {
	   CoffeesDAO dao=new CoffeesDAO();
	   List<Coffees> cofs=dao.getAllCoffees();
	   if(cofs.size()==0) {
		   return Response.noContent().build();
	   }else {
		   return Response.ok().entity(cofs).build();
	   }
	   
   }
}

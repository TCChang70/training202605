import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
      CoffeeDAO dao=new CoffeeDAO();
      List<Coffee> data=dao.getAllCoffees();
      if(data==null)
    	  return Response.noContent().build();
      else
    	  return Response.ok().entity(data).build();
    			  
   }
   
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.TEXT_HTML)
   public Response saveCoffee(Coffee cof) {
	   CoffeeDAO dao=new CoffeeDAO();
	   try {
	     dao.persist(cof);
	     return Response.ok().entity("success").build();
	   }catch(Exception ex) {
		  return Response.ok().entity("Failed "+ex.getMessage()).build(); 
	   }
   }
   
   @PUT
   @Path("/{coffeename}")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.TEXT_HTML)
   public Response saveCoffee(@PathParam("coffeename")String cofName ,Coffee cof) {
	   CoffeeDAO dao=new CoffeeDAO();
	   try {
	     dao.merge(cofName, cof);
	     return Response.ok().entity("update success").build();
	   }catch(Exception ex) {
		  return Response.ok().entity("update Failed "+ex.getMessage()).build(); 
	   }
   }
   
   @DELETE
   @Path("/{coffeename}")   
   @Produces(MediaType.TEXT_HTML)
   public Response deleteCoffee(@PathParam("coffeename")String cofName) {
	   CoffeeDAO dao=new CoffeeDAO();
	   try {
	     dao.delete(cofName);
	     return Response.ok().entity("Delete success").build();
	   }catch(Exception ex) {
		  return Response.ok().entity("Delete Failed "+ex.getMessage()).build(); 
	   }
   }
}

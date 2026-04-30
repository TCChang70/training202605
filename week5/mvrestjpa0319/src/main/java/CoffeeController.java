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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCoffee(Coffee cf) {
		CoffeeDAO dao=new CoffeeDAO();
		boolean flag=dao.insertCoffee(cf);
		if(flag) {
			return Response.ok().entity("insert success").build();
		}else {
			return Response.noContent().build();
		}
	}
	
	@PUT
	@Path("/{cofname}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCoffee(@PathParam("cofname")String cofName,Coffee cf) {
		CoffeeDAO dao=new CoffeeDAO();
		boolean flag=dao.updateCoffee(cofName,cf);
		if(flag) {
			return Response.ok().entity("update success").build();
		}else {
			return Response.noContent().build();
		}
	}
	
	@DELETE
	@Path("/{cofname}")	
	public Response deleteCoffee(@PathParam("cofname")String cofName) {
		CoffeeDAO dao=new CoffeeDAO();
		boolean flag=dao.deleteCoffee(cofName);
		if(flag) {
			return Response.ok().entity("delete success").build();
		}else {
			return Response.noContent().build();
		}
	}
	
}

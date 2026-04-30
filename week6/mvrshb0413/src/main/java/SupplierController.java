
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;
import java.util.*;
@Path("/suppliers")
public class SupplierController {
	
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAllCoffees() {
	   SupplierDAO dao=new SupplierDAO();
	   List<Suppliers> sups=dao.getAllUseNative();
	   if(sups.size()==0) {
		   return Response.noContent().build();
	   }else {
		   return Response.ok().entity(sups).build();
	   }	   
   }
   @GET
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response findSupplier(@PathParam("id") int id) {
	   SupplierDAO dao=new SupplierDAO();
	   Suppliers sp=dao.findById(id);
	   if(sp==null) {
		   return Response.noContent().build();
	   }else {
		   return Response.ok().entity(sp).build();
	   }	   
   }
}
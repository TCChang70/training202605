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

import java.net.URI;
import java.util.*;

@Path("/products")
public class ProductController {
   ProductDAO dao=new ProductDAO();
   
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAllProducts() {
	   List<Product> data=dao.getAllProducts();
	   if(data==null || data.size()==0)
		   return Response.noContent().build();
	   else
		   return Response.ok().entity(data).build();
   }
   
   @GET
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response findProductById(@PathParam("id")int id) {
	   Product data=dao.getProductById(id);
	   if(data==null)
		   return Response.status(Response.Status.NOT_FOUND).build();
	   else
		   return Response.ok().entity(data).build();
   }
   
   @POST
   @Consumes(MediaType.APPLICATION_JSON)   
   public Response addProduct(Product p) {
	   boolean data=dao.addProduct(p);
	   if(data)
		   return Response.created(URI.create("products/"+p.getId())).build();
	   else
		   return Response.status(Response.Status.BAD_REQUEST).build();
   }
   
   @PUT
   @Path("/{id}")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response upDateProduct(@PathParam("id")int id,Product p) {
	   boolean data=dao.updateProduct(id, p);
	   if(!data)
		   return Response.status(Response.Status.BAD_REQUEST).build();
	   else
		   return Response.ok().entity(p).build();
   }
   
   @DELETE
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response deleteProductById(@PathParam("id")int id) {
	   Product p=dao.getProductById(id);
	   boolean data=dao.deleteProduct(id);
	   if(!data)
		   return Response.status(Response.Status.NOT_FOUND).build();
	   else
		   return Response.ok().entity(p).build();
   }
}

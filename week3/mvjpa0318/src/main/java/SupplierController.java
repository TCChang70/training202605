import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;

@Path("/suppliers")
public class SupplierController {
	SupplierDAO dao=new SupplierDAO(); 
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSuppliers() {
    	   return Response.ok().entity(dao.getAllSuppliers()).build();
    }
}

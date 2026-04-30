import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;

@Path("/suppliers")
public class SupplierController {
   
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSupplers() {
        SupplierDAO dao=new SupplierDAO();
        List<Suppliers> data=dao.getAllSuppliers();
        data.forEach(sp->{
          Set<Coffees> sets=sp.getCoffeeses();
          sets.forEach(st->st.setSuppliers(null));
        });     	
        
        if(data!=null && data.size()>0)
        	return Response.ok().entity(data).build();
        else
        	return Response.noContent().build();
	}
}

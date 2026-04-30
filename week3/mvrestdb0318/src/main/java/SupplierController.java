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

@Path("/suppliers")
public class SupplierController {
    SupplierDAO dao=new SupplierDAO();
    
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSuppliers() {
       List<Supplier> suppliers=dao.getAll();
       if(suppliers.size()==0) {
    	      return Response.noContent().build();
       }else {
    	      return Response.ok().entity(suppliers).build();
       }
	}
	
	@GET
	@Path("/{sid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBySid(@PathParam("sid") int supplierId) {
       Supplier supplier=dao.findBySupplierId(supplierId);
       if(supplier==null) {
    	      return Response.noContent().build();
       }else {
    	      return Response.ok().entity(supplier).build();
       }
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSupplier(Supplier sp) {
		boolean flag=dao.insertSupplier(""+sp.getSupId(),sp.getSupName(), sp.getStreet(), sp.getCity(), sp.getState(), sp.getZip());
		if(flag) {
			return Response.created(URI.create("suppliers/"+sp.getSupId())).build();
		}else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{sid}")
	public Response updateSupplier(@PathParam("sid") int supplierId,Supplier sp) {
		boolean flag=dao.updatesupplier(""+supplierId,sp.getSupName(), sp.getStreet(), sp.getCity(), sp.getState(), sp.getZip());
		if(flag) {
			sp.setSupId(supplierId);
			return Response.ok().entity(sp).build();
		}else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{sid}")
	public Response deleteSupplier(@PathParam("sid") int supplierId) {
		Supplier spx=dao.findBySupplierId(supplierId);		
		if(spx!=null) {
			boolean flag=dao.deleteSupplier(""+supplierId);
			if(flag)
			   return Response.ok().entity(spx).build();
			else
				return Response.status(Response.Status.BAD_REQUEST).build();	
		}else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	
}

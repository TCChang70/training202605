import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;
import com.google.gson.*;
import java.math.BigDecimal;
import java.util.*;
@Path("/suppliers")
public class SupplierController {
   SupplierDAO dao=new SupplierDAO();	
   
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAllSuppliers() {
	   List<Supplier> data=dao.getAllSuppliers();
	   data.forEach(sp->{
		  List<Coffee> cofs= sp.getCoffees();
		  cofs.forEach(c-> c.setSupplier(null));
	   });
	   if(data==null || data.size()==0)
		   return Response.noContent().build();
	   else {
		   return Response.ok().entity(data).build();
	   }
   }
   
   @GET
   @Path("/cascade")
   public Response saveCascadeSupplier() {	   
	   Coffee c1=new Coffee("Coffee A",new BigDecimal("49"),5,20);
	   Coffee c2=new Coffee("Coffee B",new BigDecimal("39"),9,50);
	   Supplier sp1=new Supplier(10,"Gjun Company","Kung Yuan Road","Taipei","TW","100");
	   
	   c1.setSupplier(sp1); c2.setSupplier(sp1);
	   List<Coffee> cofs=new ArrayList<>();
	   cofs.add(c1); cofs.add(c2);
	   sp1.setCoffees(cofs);	   
	   boolean flag=dao.addSupplier(sp1);
	   c1.setSupplier(null);c2.setSupplier(null);
	   Gson gson=new Gson();
	   String jstr=gson.toJson(sp1);
	   System.out.println(jstr);
	   if(!flag)
		   return Response.noContent().build();
	   else {
		   return Response.ok().entity("add supplier success").build();
	   }
   }
   
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   public Response saveJsonSupplier(Supplier sp) {
	  // List<Coffee> cofs=sp.getCoffees();
	  // cofs.forEach(c->c.setSupplier(sp));
	   boolean flag=dao.addSupplier(sp);
	   if(!flag)
		   return Response.noContent().build();
	   else {
		   return Response.ok().entity("add JSON supplier success").build();
	   }
   }
}

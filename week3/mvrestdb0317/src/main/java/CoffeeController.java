
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.*;
import model.*;

@Path("/coffees")
public class CoffeeController {
   CoffeeDAO dao=new CoffeeDAO();
   
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Coffee> getAllCoffees(){
	   return dao.getAll();
   }
   
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public List<Coffee> saveCoffee(Coffee cof){
	   dao.InsertCoffee(cof.getCofName(), ""+cof.getSales(), ""+cof.getTotal(), ""+cof.getSupId(), ""+cof.getPrice());
       return this.getAllCoffees();
   }
   
   @DELETE
   @Path("/{coffeeName}")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Coffee> deleteCoffee(@PathParam("coffeeName") String name){
	   dao.deleteCoffee(name);
	   return this.getAllCoffees();
   }
   
   @PUT
   @Path("/{coffeename}")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public List<Coffee> updateCoffee(@PathParam("coffeename") String cofName,Coffee cof){
	   dao.updateCoffee(cofName, ""+cof.getSales(),""+cof.getTotal() , ""+cof.getPrice(), ""+cof.getSupId());
       return this.getAllCoffees();  
   }
   
}

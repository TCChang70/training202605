import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.util.*;
@Path("/orders")
public class MyOrders {
    List<String> data=List.of("Apple","Banana","Cherry");
    
	@GET	
	public List<String> getAllOrders() {
		System.out.println("List data:"+data);
		return data;
	}
	
	@GET
	@Path("/{oid}")
	public String getOrderById(@PathParam("oid")int id) {
		if(id<data.size()) {
		   String s1=data.get(id);
		   return "order id "+id +" data is "+s1;
		}
		return "No Order";
	}
	
	@GET
	@Path("/{oid}/items/{itemid}")
	public String getOrderByItemId(@PathParam("oid")int id,@PathParam("itemid")int iid) {
		if(id<data.size()) {
		   String s1=data.get(id);
		   return "order id "+id +" data is "+s1+" input item id is "+iid;
		}
		return "No Order No Item";
	}
	
}


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import model.*;

@Path("/items")
public class ItemRestService {   

    private ItemDAO dataService = ItemDAO.getInstance();
    public ItemRestService() {    	
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems() {
    	    List<Item> data= dataService.getItemList();
    	    if(data!=null && data.size()>0)
    	    	   return Response.ok().entity(data).build();
    	    else
           return Response.status(Response.Status.NO_CONTENT).build();
    }


    @Path("/{sku}/{name}/{price}")
    @PUT     
    public Response createItem(@PathParam("sku") String sku , @PathParam("name") String name ,@PathParam("price") int price) {
        if (dataService.itemExists(sku)) {
            //status code 204
            return Response.noContent()
                      .build();
        } else {
            dataService.createItem(sku,name,new BigDecimal(price));             
            //status code 201
            //sends back new URI in header key = 'LOCATION'
            return Response.created(URI.create("items/"+sku)).build();
        }
    }
   
    @GET
    @Path("/{sku}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("sku") String sku) {
        Item item = dataService.getItemBySku(sku);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND)
                      .build();
        } else {
            return Response.ok()
                      .entity(item)
                      .build();
        }
    }
    
}



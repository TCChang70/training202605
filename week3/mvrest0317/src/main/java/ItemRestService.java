
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
    public List<Item> getItems() {
        return dataService.getItemList();
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
    @Path("/{sku}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PUT     
    public Response updateItem(@PathParam("sku") String sku ,Item item) {
        if (! dataService.itemExists(sku)) {
            //status code 204
            return Response.noContent()
                      .build();
        } else {
            Item updateItem=dataService.updateItem(sku, item);             
            if(updateItem==null)
            	  return Response.noContent()
                        .build();
            else
              return Response.ok()
                    .entity(updateItem)
                    .build();
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




import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import model.*;

@Path("/customers")
public class CustomerService {
    private CustomerDAO dataService = CustomerDAO.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return dataService.getCustomerList();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String createCustomer(Customer newCustomer) {
    	    System.out.println("received:"+newCustomer);
        return dataService.addCustomer(newCustomer);
    }
    
    @POST
    @Path("/data")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String createCustomer(@FormParam("name") String name,
                        @FormParam("address") String address,
                        @FormParam("phone-number") String phoneNumber) {
            return dataService.addCustomer(name, address, phoneNumber);
        }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") String id) {
        return dataService.getCustomerById(id);
    }
}
 


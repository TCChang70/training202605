
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import model.*;

@Path("/orders")
public class OrderRS {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Order> getOrders() {
        return OrderDAO.getInstance().getAllOrders();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteOrderById(@PathParam("id") int id) {
        return OrderDAO.getInstance().deleteOrderById(id);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrderById(@PathParam("id") int id) {
        return OrderDAO.getInstance().getOrderById(id);
    }
}



import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.*;
import java.util.*;
@Path("/employees")
public class EmployeeController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {
    	EmployeeDAO dao=new EmployeeDAO(); 
    	List<Employee> emps=dao.getAllEmployees();
    	if(emps!=null && emps.size()>0)
    	   return Response.ok().entity(emps).build();
    	else
    	   return Response.noContent().build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public Response addEmployees(Employee emp) {
    	EmployeeDAO dao=new EmployeeDAO();
    	try {
    	   dao.persist(emp);
    	   return Response.ok().entity("Add OK").build();
    	}catch(Exception ex) {
    		return Response.ok().entity("Add Error "+ex.getMessage()).build();
    	}  
    }
    @PUT
    @Path("/{employeeID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public Response updateEmployee(@PathParam("employeeID")int id ,Employee emp) {
    	EmployeeDAO dao=new EmployeeDAO();
    	try {
    	   dao.merge(id, emp);
    	   return Response.ok().entity("Update OK").build();
    	}catch(Exception ex) {
    		return Response.ok().entity("Update Error "+ex.getMessage()).build();
    	}  
    }
    @DELETE
    @Path("/{employeeID}")
    @Produces(MediaType.TEXT_HTML)
    public Response deleteEmployee(@PathParam("employeeID")int id) {
    	EmployeeDAO dao=new EmployeeDAO();
    	try {
    	   dao.delete(id);
    	   return Response.ok().entity("Delete OK").build();
    	}catch(Exception ex) {
    		return Response.ok().entity("Delete Error "+ex.getMessage()).build();
    	}  
    }
}

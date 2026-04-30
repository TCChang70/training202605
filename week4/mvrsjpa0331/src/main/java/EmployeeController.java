import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;

import java.net.URI;
import java.util.*;

@Path("/employees")
public class EmployeeController {
	
	EmployeeDAO dao=new EmployeeDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {
    	    List<Employee> data=dao.getAllEmployees();
    	    if(data!=null && data.size()>0) {
    	    	   return Response.ok().entity(data).build();
    	    }else {
    	    	   return Response.status(Response.Status.NO_CONTENT).build();
    	    }
    }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployee(Employee emp) {
    	    boolean flag=dao.addEmployee(emp); 
    	    if(flag)
    	    	   return Response.created(URI.create("employees/"+emp.getEmployeeNumber())).build();
    	    else {
    	    	   return Response.status(Response.Status.BAD_REQUEST).build();
    	    }
    }
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)	
    public Response deleteEmployee(@PathParam("id") int id) {
		Employee emp=dao.findById(id);
    	    boolean flag=dao.deleteEmployee(id); 
    	    if(flag)
    	    	   return Response.ok().entity(emp).build();
    	    else {
    	    	   return Response.status(Response.Status.BAD_REQUEST).build();
    	    }
    }
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("id") int id,Employee emp) {
		Employee found=dao.updateEmployee(id, emp);    	  
    	    if(found!=null)
    	    	   return Response.ok().entity(emp).build();
    	    else {
    	    	   return Response.status(Response.Status.BAD_REQUEST).build();
    	    }
    }
}

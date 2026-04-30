import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;
import java.util.*;

@Path("/students")
public class StudentController {
   
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCoffees() {
		StudentDAO dao=new StudentDAO();
		List<Student> ss=dao.getAllStudents();
		if(ss==null || ss.size()==0) {
			return Response.noContent().build();
		}else {
			return Response.ok().entity(ss).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveStudent(Student s) {
		StudentDAO dao=new StudentDAO();
		boolean flag=dao.addStudent(s);
		if(flag) {
			return Response.ok().entity(s).build();
		}else {
			return Response.noContent().build();
		}
	}
	
	@PUT
	@Path("/{sid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStudent(@PathParam("sid")int sid,Student s) {
		StudentDAO dao=new StudentDAO();
		boolean flag=dao.updateStudent(sid, s);
		if(flag) {
			return Response.ok().entity(s).build();
		}else {
			return Response.noContent().build();
		}
	}
	
	@DELETE
	@Path("/{sid}")	
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStudent(@PathParam("sid")int sid) {
		StudentDAO dao=new StudentDAO();
		Student s=dao.findById(sid);
		boolean flag=dao.deleteStudent(sid);
		if(flag) {
			return Response.ok().entity(s).build();
		}else {
			return Response.noContent().build();
		}
	}
}

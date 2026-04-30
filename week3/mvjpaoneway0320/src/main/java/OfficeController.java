import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;
import java.util.*;
@Path("/offices")
public class OfficeController {
	OfficeDAO dao=new OfficeDAO();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllOffice() {
		List<Office> data=dao.getAllOffices();
		if(data==null || data.size()==0)
			 return Response.noContent().build();
		else
			return Response.ok().entity(data).build();
	}
}

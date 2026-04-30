

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Supplier;
import model.SupplierDAO;

/**
 * Servlet implementation class SupplierInsertServlet
 */
@WebServlet("/supplierinsert")
public class SupplierInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid=request.getParameter("sid");
        String sname=request.getParameter("sname");
        String street=request.getParameter("street");         
        String city=request.getParameter("city");
        String state=request.getParameter("state");        
        String zip=request.getParameter("zip");
        SupplierDAO dao=new SupplierDAO();
        dao.insertSupplier(sid, sname, street, city, state,zip);
        
        List<Supplier> data=dao.getAll();
		request.setAttribute("suppliers", data);
		request.getRequestDispatcher("viewsupplier.jsp").forward(request, response);
	}

}



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import model.*;
/**
 * Servlet implementation class CoffeeInsertServlet
 */
@WebServlet("/coffeeinsert")
public class CoffeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("insert coffee : ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String coffee=request.getParameter("coffee");
        String sale=request.getParameter("sale");
        String total=request.getParameter("total");         
        String supplier=request.getParameter("supplier");
        String price=request.getParameter("price");        
        CoffeeDAO dao=new CoffeeDAO();
        dao.InsertCoffee(coffee, sale, total, supplier, price);
        
        List<Coffee> data=dao.getAll();
		request.setAttribute("coffees", data);
		request.getRequestDispatcher("viewcoffee.jsp").forward(request, response);
	}

}

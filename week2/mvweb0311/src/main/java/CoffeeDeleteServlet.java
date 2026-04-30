

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coffee;
import model.CoffeeDAO;

/**
 * Servlet implementation class CoffeeDeleteServlet
 */
@WebServlet("/coffeedelete")
public class CoffeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeDeleteServlet() {
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
		//doGet(request, response);
		String coffee=request.getParameter("coffee");
          
        CoffeeDAO dao=new CoffeeDAO();
        dao.deleteCoffee(coffee);
        
        List<Coffee> data=dao.getAll();
		request.setAttribute("coffees", data);
		request.getRequestDispatcher("viewcoffee.jsp").forward(request, response);
	}

}

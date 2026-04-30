

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
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
	ProductDAO dao=new ProductDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String sb=request.getParameter("submit");
		String id=request.getParameter("sid");
		String name=request.getParameter("pname");
		String price=request.getParameter("price");
		
        switch(sb) {
            case "save":
            	  Product x=new Product(id,name,Integer.parseInt(price));
            	  boolean b=dao.addProduct(x);
            	  request.setAttribute("flag", b);
            	  request.getRequestDispatcher("productStatus.jsp").forward(request, response);
            	  break;
            case "list":
            	   List<Product> pts=dao.getAllProducts();
            	   request.setAttribute("products", pts);
            	   request.getRequestDispatcher("productlist.jsp").forward(request, response);
            	   break;
            case "update":
            	   Product y=new Product(id,name,Integer.parseInt(price));
            	   Product edit=dao.update(id, y);
            	   System.out.println("updated product is"+edit);
            	   request.setAttribute("products", dao.getAllProducts());
            	   request.getRequestDispatcher("productlist.jsp").forward(request, response);
            	   break;
            	   
            case "delete":
            	  Product d=dao.remove(id);
            	  System.out.println("deleted product is"+d);
            	  request.setAttribute("products", dao.getAllProducts());
           	  request.getRequestDispatcher("productlist.jsp").forward(request, response);
           	  break;
            
        }
	}

}

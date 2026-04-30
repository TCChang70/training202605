

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculateServlet
 */
@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateServlet() {
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
		String v1=request.getParameter("num1");
		String v2=request.getParameter("num2");
		String sb=request.getParameter("sb");
		double d1=Double.parseDouble(v1);
		double d2=Double.parseDouble(v2);
		response.setContentType("text/html;charset=utf-8");
		switch(sb) {
		   case "add":
			   response.getWriter().append("<h2>"+v1).append("+"+v2).append("="+(d1+d2)+"</h2>");
			   break;
		   case "subtract":
			   response.getWriter().append("<h2>"+v1).append("-"+v2).append("="+(d1-d2)+"</h2>");
			   break;
		   case "multiply":
			   response.getWriter().append("<h2>"+v1).append("x"+v2).append("="+(d1*d2)+"</h2>");
			   break;
		   case "divide":
			   response.getWriter().append("<h2>"+v1).append("/"+v2).append("="+(d1/d2)+"</h2>");
			   break;
		}
	}

}

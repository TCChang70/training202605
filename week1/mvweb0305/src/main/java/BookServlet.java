
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/bookop")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		HttpSession hs = request.getSession();
		Object obj = hs.getAttribute("booklist");
		if (obj == null) {
			Book b = new Book();
			hs.setAttribute("booklist", b.getData());
			obj=hs.getAttribute("booklist");
		}
		List<Book> bookData = (List<Book>) obj;
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		Book b1 = new Book(Integer.parseInt(bid), bname, author, Integer.parseInt(price));
		bookData.add(b1);
		hs.setAttribute("booklist", bookData);
		System.out.println(bookData);
		response.getWriter().append("Books Saved");

	}

}

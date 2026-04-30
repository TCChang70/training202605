
import model.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;

public class InitializeProductList implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String catalogFileName = context.getInitParameter("catalogFileName");
		InputStream is = null;
		BufferedReader catReader = null;
		try {
			is = context.getResourceAsStream(catalogFileName);
			catReader = new BufferedReader(new InputStreamReader(is));
			String ProductString;
			ArrayList<Product> catalog = new ArrayList<>();
			while ((ProductString = catReader.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(ProductString, "|");
				String code = tokens.nextToken();
				String price = tokens.nextToken();
				String quantityStr = tokens.nextToken();
				int quantity = Integer.parseInt(quantityStr);
				String description = tokens.nextToken();
				Product p = new Product(code, price, quantity, description);
				catalog.add(p);
			}
			System.out.println("List:"+catalog);
			context.setAttribute("catalog", catalog);
			context.log("The product list was initialized.");
		} catch (Exception e) {
			context.log("Parsing catalog.txt error!");
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}
}

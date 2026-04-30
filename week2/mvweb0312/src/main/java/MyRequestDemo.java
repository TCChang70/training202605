

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.*;
/**
 * Application Lifecycle Listener implementation class MyRequestDemo
 *
 */
@WebListener
public class MyRequestDemo implements ServletRequestListener, ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public MyRequestDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }
    
    /**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
     	 logout("request init");
         ServletRequest sr = sre.getServletRequest();

         if (sr.getRemoteAddr().startsWith("127")||(sr.getRemoteAddr().startsWith("0")) && sr.getRemoteAddr().endsWith("1")) {
             sr.setAttribute("isLogin", new Boolean(true));
         } else {
             sr.setAttribute("isLogin", new Boolean(false));
         }
        List<Map<String,String>> products=new ArrayList<>();
        Map<String,String> m1=new HashMap<>();
        m1.put("id", "1"); m1.put("name", "Apple");m1.put("price", "$2.99");
        products.add(m1);
        m1=new HashMap<>();
        m1.put("id", "2"); m1.put("name", "Banana");m1.put("price", "$1.99");
        products.add(m1);
        sr.setAttribute("products", products); 

    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    }

	

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    	  logout("Request attributeAdded('" + srae.getName() + "', '" + srae.getValue() + "')");

    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    }
	
    private void logout(String msg) {
        System.out.println(msg);
    }

}

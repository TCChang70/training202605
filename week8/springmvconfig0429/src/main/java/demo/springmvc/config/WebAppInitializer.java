package demo.springmvc.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Root Application Context 的設定類別
     * （Service、Repository 等非 Web 的 Bean 放這裡）
     * 目前範例只有 MVC 層，回傳 null 即可。
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /**
     * DispatcherServlet 的設定類別
     * 對應原本的 *-servlet.xml
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { MvcConfig.class };  // ← 指向 MvcConfig
    }

    /**
     * DispatcherServlet 攔截的 URL 模式
     * "/" 表示攔截所有請求（等同 web.xml 的 <url-pattern>/</url-pattern>）
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}

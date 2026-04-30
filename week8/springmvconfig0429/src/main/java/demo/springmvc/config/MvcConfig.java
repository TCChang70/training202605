package demo.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration          // 標記此類為 Spring 設定類別（取代 XML beans）
@EnableWebMvc           // 啟用 Spring MVC 注解支援（取代 <mvc:annotation-driven/>）
@ComponentScan("demo.springmvc")  // 掃描 Controller（取代 <context:component-scan>）
public class MvcConfig implements WebMvcConfigurer {

    /**
     * ViewResolver：根據 Controller 回傳的字串組合出 JSP 路徑
     * 取代 XML 中的 <bean class="InternalResourceViewResolver">
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");   // JSP 放置目錄
        resolver.setSuffix(".jsp");              // 自動加上副檔名
        return resolver;
    }

    /**
     * 讓靜態資源（CSS、JS、圖片）不被 DispatcherServlet 攔截
     * 取代 XML 中的 <mvc:default-servlet-handler/>
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}

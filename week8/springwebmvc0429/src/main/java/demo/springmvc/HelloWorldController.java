package demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller                 // 標記此類為 Spring MVC 控制器
public class HelloWorldController {

    @RequestMapping(value={"/hello"},method=RequestMethod.GET)         // 處理 GET /hello 的請求
    public String hello(Model model) {
        // 將資料放入 Model，JSP 可用 ${greeting} 取得
        model.addAttribute("greeting", "Hello World Spring Web MVC");
        return "helloworld";          // 回傳 View 名稱（不含路徑與副檔名）
    }
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String doRedirect(Model model) {
        return "redirect:/hello";   // ← 重新導向到 /hello
    }
    
    @RequestMapping("/userinfo")
    public String userInfo(
            Model model,
            @RequestParam(value = "name", defaultValue = "Guest") String name) {

        model.addAttribute("name", name);

        if ("admin".equals(name)) {
            model.addAttribute("email", "admin@demo.com");
        } else {
            model.addAttribute("email", "Not set");
        }
        return "userInfo";
    }
}

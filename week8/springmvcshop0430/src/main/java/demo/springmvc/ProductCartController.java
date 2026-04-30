package demo.springmvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.springmvc.model.ProductModel;


@Controller
@RequestMapping(value = "/productcart")   // 類別層級的 URL 前綴
public class ProductCartController {

    // GET /productcart → 載入商品列表，傳給 index.jsp
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        ProductModel productModel = new ProductModel();
        modelMap.put("products", productModel.findAll());  // 傳資料到視圖
        return "index";  // → /WEB-INF/views/index.jsp
    }
}

package demo.springmvc;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import demo.springmvc.model.*;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    // GET /cart/index → 顯示購物車頁面
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "cart/cartindex";  // → /WEB-INF/jsp/cart/cartindex.jsp
    }

    // GET /cart/buy/{id} → 加入商品到購物車
    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public String buy(@PathVariable("id") String id, HttpSession session) {
        ProductModel productModel = new ProductModel();

        if (session.getAttribute("cart") == null) {
            // 購物車不存在：建立新購物車並加入商品
            List<Item> cart = new ArrayList<Item>();
            cart.add(new Item(productModel.find(id), 1));
            session.setAttribute("cart", cart);
        } else {
            // 購物車已存在：檢查商品是否已在車內
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = this.exists(id, cart);

            if (index == -1) {
                // 商品不在車內：新增
                cart.add(new Item(productModel.find(id), 1));
            } else {
                // 商品已在車內：數量 +1
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart/index";  // 加完後重導到購物車頁
    }

    // GET /cart/remove/{id} → 從購物車移除商品
    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") String id, HttpSession session) {
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "redirect:/cart/index";
    }

    // 輔助方法：在購物車中尋找指定 id 的商品，回傳索引（找不到回傳 -1）
    private int exists(String id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
}

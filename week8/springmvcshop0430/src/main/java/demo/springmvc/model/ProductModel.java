package demo.springmvc.model;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// ProductModel 負責提供商品資料（初期用假資料，後期換成 DB）
public class ProductModel {
    private List<Product> products;

    public ProductModel() {
        // 初始化假資料（整合 Hibernate 後會替換這段）
//        this.products = new ArrayList<Product>();
//        this.products.add(new Product("p01", "JBud Elite",   "images/p1.jpg", 20));
//        this.products.add(new Product("p02", "EdiMax Wifi",  "images/p2.jpg", 21));
//        this.products.add(new Product("p03", "Asus Laptop",  "images/p3.jpg", 22));
    	from_mvDB();
    }

    // 取得全部商品
    public List<Product> findAll() {
        return this.products;
    }

    // 依 id 查詢單一商品
    public Product find(String id) {
        for (Product product : this.products) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;  // 找不到回傳 null
    }
    private void from_mvDB() {
        // 1. 建立 Hibernate 設定物件
        Configuration configObj = new Configuration();
        //configObj.addAnnotatedClass(demo.springmvc.model.Product.class);  // 註冊 Entity
        configObj.configure("hibernate.cfg.xml");          // 載入設定檔

        // 2. 開啟 Session（對應一次 DB 連線）
        Session session = configObj.buildSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            // 3. 使用 HQL（Hibernate Query Language）查詢
            //    HQL 使用類別名稱，不是資料表名稱
            products = session.createQuery("FROM Product").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();  // 4. 必須關閉 Session 釋放連線
        }
    }

}

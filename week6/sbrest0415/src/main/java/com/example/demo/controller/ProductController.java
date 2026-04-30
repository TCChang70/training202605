package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.demo.model.*;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	 @Autowired
	 ProductDAO  dao;
	
	 private static Map<String, Product> repos = new HashMap<>();
	   static {
	      Product honey = new Product();
	      honey.setId("1");
	      honey.setName("Honey");
	      repos.put(honey.getId(), honey);

	      Product almond = new Product();
	      almond.setId("2");
	      almond.setName("Almond");
	      repos.put(almond.getId(), almond);
	   }
	@GetMapping("/generate/{num}")
	public ResponseEntity<List<Product>> generateProduct(@PathVariable("num")int num) {   	    
		List<Product> data=new ArrayList<Product>(dao.generate(num).values());
	     return new ResponseEntity<>(data, HttpStatus.OK);
  }
    @GetMapping()
	public ResponseEntity<List<Product>> getProduct() {
    	 List<Product> data=new ArrayList<Product>(repos.values());
	     return new ResponseEntity<>(data, HttpStatus.OK);
   }
    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
 	   repos.put(product.getId(), product);
       return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")    
    public ResponseEntity<Object> updateProduct(@PathVariable("id")String id,@RequestBody Product product) {
 	   Product p=repos.get(id); 	  
 	   if(p!=null) {
 		  repos.put(id, product);
         return new ResponseEntity<>(product, HttpStatus.OK);
 	   }
 	   else
 		 return new ResponseEntity<>("Not Modified", HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping("/{id}")    
    public ResponseEntity<Object> deleteProduct(@PathVariable("id")String id) {
 	   Product p=repos.remove(id); 	  
 	   if(p!=null) { 		  
         return new ResponseEntity<>(p, HttpStatus.OK);
 	   }
 	   else
 		 return new ResponseEntity<>("Not Deleted", HttpStatus.BAD_REQUEST);
    }

}

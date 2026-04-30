package com.example.demo.controller;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/fakeproducts")
public class FakeProductController {
	
     @Autowired
     FakeProductRepository dao;
	
	@PostMapping()
	public FakeProduct saveProduct(@RequestBody FakeProduct product) {		
		dao.save(product);
		return product;
	}
	
	@GetMapping()
	public ResponseEntity<Object> getAllFakeProducts(){
		RestTemplate rt=new RestTemplate();
		FakeProduct[] pts=rt.getForObject(URI.create("https://fakestoreapi.com/products"),FakeProduct[].class );
        if(pts.length>0) {
          saveToTable(pts);	
		  return new ResponseEntity(pts,HttpStatus.OK);
        }
        else
         return ResponseEntity.noContent().build();
	}
	void saveToTable(FakeProduct[] pts){
		for(FakeProduct f : pts) {
			if(f.getImage()!=null) {
				RestTemplate rt=new RestTemplate();
				byte[] pic=rt.getForObject(URI.create(f.getImage()),byte[].class );
				if(pic!=null && pic.length>0)
			       f.setPicture(pic);
				dao.save(f);
			}
		}
	}
	@GetMapping(value = { "/productimage/{code}" })
   	public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
   			@PathVariable("code") int code) throws IOException {
		
   		Optional<FakeProduct> product = dao.findById(code);
   		
   		if (product.isPresent()) {   			
   			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
   			response.getOutputStream().write(product.get().getPicture());
   		}
   		response.getOutputStream().close();
   	}
       
       @GetMapping(value = "/showall")
       public ModelAndView getAllImage() {
       	ModelAndView mv=new ModelAndView("showfakeall");    	
   		mv.addObject("products", dao.findAll());
       	return mv;
       }
}
 

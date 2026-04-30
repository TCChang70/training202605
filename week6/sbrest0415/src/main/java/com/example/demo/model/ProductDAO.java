package com.example.demo.model;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class ProductDAO {
   public Map<String, Product> generate(int n){
	   Map<String,Product> data=new HashMap<>();
	   for(int i=1;i<=n;i++) {
		   Product p=new Product(""+i,"Product A"+i);
		   data.put(""+i,p);
	   }
	   return data;
   }
}

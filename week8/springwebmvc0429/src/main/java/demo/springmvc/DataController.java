package demo.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
public class DataController {
	
   @RequestMapping(value={"/user"},method=RequestMethod.GET)   
   public @ResponseBody Map<String,String> create(){
	   Map<String,String> obj=Map.of("username","John Lee","password","lee123");
	   return obj;
   }
}

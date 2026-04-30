
import java.nio.file.*;
import java.util.*;
public class ReadProductFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        Path p=Paths.get("c:/temp/products.txt");
        List<String> pts= Files.readAllLines(p);
        System.out.println(pts);
        List<Product> list= pts.stream().map(str->{
           String[] array=str.split(",");
           return new Product(array[0],array[1],Integer.parseInt(array[2]));
        }).toList();
        
        System.out.println(list);
        
	}

}

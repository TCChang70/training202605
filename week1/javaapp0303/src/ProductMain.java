import java.io.*;
import java.util.*;
public class ProductMain {
	
	static void saveProduct() throws Exception {
		   List<Product> data=new ArrayList<>();
	       data.add(new Product("P01","Apple",50));
	       data.add(new Product("P02","Banana",30));
	       data.add(new Product("P03","Cherry",350));
	       OutputStream out=new FileOutputStream("c:/temp/products.bin");
	       ObjectOutputStream obj=new ObjectOutputStream(out);
	       obj.writeObject(data);
	       out.close();
	       System.out.println("Data Serialized");
	}
	
	static List<Product> readProduct() throws Exception {
		InputStream in=new FileInputStream("c:/temp/products.bin");
	    ObjectInputStream obj=new ObjectInputStream(in);
	    Object list=obj.readObject();
	    if(list!=null) {
	    	   List<Product> products=( List<Product>)list;
	    	   return products;
	    } else
		return new ArrayList<Product>();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		saveProduct();
		List<Product> values= readProduct();
		System.out.println(values);
	}

}

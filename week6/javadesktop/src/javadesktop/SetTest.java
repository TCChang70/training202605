package javadesktop;
import java.util.*;

public class SetTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Set<MyValues> sets=new HashSet<>();
      sets.add(new MyValues(1));
      sets.add(new MyValues(2));
      sets.add(new MyValues(1));
      for(MyValues m :sets) {
    	  System.out.println(m);
      }
	}

}

package javadesktop;

import java.util.*;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<MyValues> sets=new ArrayList<>();
	      sets.add(new MyValues(1));
	      sets.add(new MyValues(2));
	      sets.add(new MyValues(3));
	      sets.remove(new MyValues(2));
	      for(MyValues m :sets) {
	    	  System.out.println(m);
	      }
	}

}

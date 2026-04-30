import java.util.*;
import java.util.function.*;
import java.util.stream.*;
public class ListForEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    List<Integer> data1= new ArrayList<>( Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        List<Integer> data2=new ArrayList(List.of(1,2,3,4,5,6,7,8,9,10));
        Consumer<Integer>  cs=new  Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}        	     
        };
        Consumer<Integer>  cs2 = t-> System.out.println(t);
        
        data1.forEach(cs2);
        
        Predicate<Integer> pd=new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return t%2==0;
			}        	
        };
        data2.removeIf(t->t%2==0);
        data2.forEach(t->System.out.println(t));
        
        UnaryOperator<Integer> op=new UnaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t*2;
			}        	
        };
        data1.replaceAll(t->t*t);
        data1.forEach(t->System.out.println(t));
	}

}

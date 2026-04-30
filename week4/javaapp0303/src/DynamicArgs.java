
public class DynamicArgs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       print("A","B","C");
       print("A","B","C","X","Y","Z");
	}
    static void print(String... strings) {
    	   for(int i=0;i<strings.length;i++) {
    		   System.out.print(strings[i].toLowerCase());
    	   }
    	   System.out.println();
    }
}

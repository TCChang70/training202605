import java.util.*;
public class Exercise {
	static void spacechar(String str) {
		String[] strArray=str.split(" ");
		int length=str.length();
		int len=0;
		for(String s: strArray) {
			len+=s.length();
		}
		System.out.println("sub total length(no space):"+(len));
		System.out.println("space :"+(length-len));
		
	}
    static void lowerUpper(String str) {
    	    int lower=0,upper=0;
    	    for(int i=0;i<str.length();i++) {
    	    	   if(str.charAt(i)>='A' && str.charAt(i)<='Z')
    	    		   upper++;
    	    	   if(str.charAt(i)>='a' && str.charAt(i)<='z')
    	    		   lower++;
    	    }
    	    System.out.println("LowerCase:"+lower);
    	    System.out.println("UpperCase:"+upper);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input =new Scanner(System.in);
        System.out.print("Input String:");
        String str=input.nextLine();
        lowerUpper(str);
        spacechar(str);
	}

}

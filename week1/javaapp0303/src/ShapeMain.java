
public class ShapeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   double side=5;	
       Shape square= ()-> side*side;
       double radius=10.0;
       Shape circle=()-> Math.PI*radius*radius;
       System.out.println("Square:"+square.area());
       System.out.println("Circle:"+circle.area());
	}

}

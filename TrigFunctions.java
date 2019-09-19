
public class TrigFunctions {
	public static void main(String[]args){
		double r;
		double s;
		double c;
		double t;
		System.out.println("Please enter angle in radian form ");
		r = IO.readDouble();
		s = Math.sin(r);
		c = Math.cos(r);
		t = Math.tan(r);
	
		System.out.println("The sin of angle " + r + " is " + s);
		System.out.println("The cos of angle " + r + " is " + c);
		System.out.println("The tan of angle " + r + " is " + t);
		
		//IO.outputDoubleAnswer(s);
		//IO.outputDoubleAnswer(c);
		//IO.outputDoubleAnswer(t);
		
		
	}

}

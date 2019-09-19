/*
 * Author: Dhruv Pate;
 * Play with Java Data Types
 */
public class Types {
	public static void main(String[] args) {
		
		double f = 69;
		float c = (float)f; //Cast f to type float
		
		int x = 50;
		int y = 15;
		float z = x/y; //integer divided by integer, result is integer
		System.out.println("Z = " + z); //implicit casting from float to string
		
		float q = x * 1.0f / y;
		System.out.println("q =" + q);
		
		int quotient = x/y;
		int remainder = x%y;
		System.out.println(x+"/" +y+"=" +quotient+"remainder=" +remainder);
		
		//char ch = "a"; // Won't compile, "a" is a string
		char ch1 ='a';
		char ch2 = 'A';
		System.out.println("ch1 = "+ch1 + ", ch2 =" + ch2);
		
		//overflow. A byte holds integers in the range of -128 to 127
		byte a = 100;
		byte b = 100;
		byte d = (byte)(a+b); //overflow because the number 200 doesn't dit into 8 bits
		System.out.println("d =" +d);
		
		//floating point roundoff error
		double p = 0.7;
		double u = 0.9;
		double r = p + 0.1;
		double t = u - 0.1;
		System.out.println(r==t);
		System.out.println(Math.abs(r - t) < 0.0001);
		
		System.out.println(Math.ceil(3.5));
		System.out.println(Math.floor(3.5));
		System.out.println(Math.sqrt(a));
	}
}

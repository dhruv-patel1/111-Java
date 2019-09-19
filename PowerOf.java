/*
 * Computes the power of base to the degree 
 */
public class PowerOf {
	public static void main (String[] args) {
		
		System.out.println("Enter base: ");
		double base = IO.readDouble();
		
		System.out.println("Enter exponent: ");
		double exponent = IO.readDouble();
		
		double answer = Math.pow(base, exponent);
		IO.outputDoubleAnswer(answer);
		
		
	}

}

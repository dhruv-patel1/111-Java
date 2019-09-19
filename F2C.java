/*
 * Converts from Fahrenheit to Celsius 
 */
public class F2C {
	public static void main(String[] args) {
		System.out.print("Please enter the temperatueee in Fahrenheit: ");
		double tempF = IO.readDouble();
		double tempC = (tempF-32) * 5 / 9;
		IO.outputDoubleAnswer(tempC);
		
	}
}

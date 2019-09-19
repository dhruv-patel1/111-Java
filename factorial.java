
public class factorial {
	public static void main(String[]args) {
		System.out.print("Enter number: ");
		int n = IO.readInt();
		
		int fact = 1;
		for (int i = 2; i <= n; i++) {
			fact *= i;
		}
		IO.outputIntAnswer(fact);
	
		fact = 1;
		int i = 2;
		while (i<=n ) {
			fact *= i;
			i++;
			
		}
		IO.outputIntAnswer(fact);
	}

}

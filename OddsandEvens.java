
public class OddsandEvens {
	public static void main(String[]args) {
		int n = IO.readInt();
		
		if (n <= 0) {
			return;
		}
		for (int i = 1; i <= n; i+=1) {
			if (i%3 == 0 && i % 2 == 0)
			{
				System.out.print(i + " Even ");
			}
			if (i%3 == 0 && i%2 != 0) 
			{
				System.out.print(i+" Odd ");
			
			}
			if(i%3!=0 && i%2==0) {
				System.out.print(i+" Very Even ");
			}
			if(i%3 != 0 && i%2 != 0) {
				System.out.print(i+" Very Odd ");
			}
		}
	}
}

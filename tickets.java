
public class tickets {
	public static void main(String[]args) {
		System.out.print("Enter the amount of tickets: ");
		int nTickets = IO.readInt();
		double cost = 0.0;
		
		while (nTickets > 0) {
			char tType;
				
			do {
				System.out.print("Ticket type [a]-adult, [c]-child, [s]-senior ");
				tType = IO.readChar();
				if(tType =='c')
				{
					cost +=5;
				}
				else if(tType == 'a') {
					cost+=10;
				}
				else if (tType =='s') {
					cost+=3;
				}
				else {
					System.out.println("Error: Invalid input ");
				}
			}
			while(tType != 'c' && tType != 'a' && tType != 'a');
			{
				nTickets = 1;
			}
			IO.outputDoubleAnswer(cost);
		
		}
		
		
	}
}


public class Cube {
	public static void main(String[]args) {
		System.out.print("Enter rows: ");
		int column = IO.readInt();
		System.out.print("Enter columns: ");
		int rows = IO.readInt();
		
		for (int i = 0; i <column; i++) {
			for (int j =0; j< rows; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
}

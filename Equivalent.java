
public class Equivalent {
	
	public static void main(String[]args) {
		System.out.println("How many elements in the char array: ");
		int len = IO.readInt();
		char []array = new char[len];
		
		System.out.println("Enter " + len + " elements: ");
		for (int i=0; i<len; i++) {
			array[i]=IO.readChar();
		}
		System.out.println("Please enter string: ");
		String s = IO.readString();
		
		boolean isEqual = equivalent(array,s);
		
	if (isEqual) {
		System.out.print("True");
	}
	else {
		System.out.print("False");
	}
		
	}
	
	public static boolean equivalent(char[]array, String s) { 
		if (array.length != s.length()) {
			return false;
		}
		for (int i=0; i<array.length;i++) {
			if (array[i] != s.charAt(i)) {
				return false;
				
			}
			return true;
		}
		
		
	}

}

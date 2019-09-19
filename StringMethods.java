
public class StringMethods {
	public static boolean palindrome(String str) {
		for (int i = 0; i <= str.length()/2; i++) {
			int k = str.length() - 1 -i;
			char cI = str.charAt(i); // grab character at index i
			char cK = str.charAt(k); // grab character at index k
			
			if (cI != cK) {
				return false;
			}
		}
		//All characters are the same
		return true;
	}
	public static void main(String[]args) {
		System.out.print("Enter string: ");
		String input = IO.readString();
		boolean result = palindrome (input); // return value is stored into variable result
		IO.outputBooleanAnswer(result);
		
		System.out.print("Enter another string: ");
		String input2 = IO.readString();
		result = input.contentEquals(input2);
		IO.outputBooleanAnswer(result);
	}
	
	
}

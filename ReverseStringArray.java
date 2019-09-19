
public class ReverseStringArray {


	public static void reverse(String[][]str) {
		for (int i=0; i<str.length; i++) {
			
			for (int j=0; j<str[i].length; j++) {
				String temp = "";
				
				for (int x=0; x<str[i][j].length(); x++) {
					temp += str[i][j].charAt(str[i][j].length()-x-1);
				}
				str[i][j] = temp;
			}
		}
	}
}

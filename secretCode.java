
public class secretCode {
	public static void main(String[]args) {
		String x = "gvdl zpv";
		String a = decode(x);
		System.out.print(a);
		
	}
	
	public static String decode(String code) {
		String fin = "",alpha = "abcdefghijklmnopqrstuvwxyz";
		code = code.toLowerCase();
		for (char i : code.toCharArray()) {
			if(i == ' ')
				fin += " ";
			else
				fin += Character.toString(alpha.charAt(alpha.indexOf(i)-1));
		}
		return fin;
	
		 
		
	}

}

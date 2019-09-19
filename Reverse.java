
public class Reverse {

	public static void main(String[] args) 
	{
		String str = "dog";
		String s = reverse(str);
		System.out.print(s);

	}
	
	public static String reverse(String s) 
	{
	String temp = "";
	for(int i = 0; i<s.length(); i++) 
	{
		temp = s.charAt(i) + temp;
	}
	return temp;
	}

}


public class FIx {

	public static void main(String[] args) 
	{
		String str = "sAi Saka is Cool";
		String a = fix(str);
		System.out.print(a);
	}
	public static String fix(String s) 
	{
		String temp = s.toLowerCase();
		char a = temp.charAt(0);
		String temp2 = new StringBuilder().append("").append(a).toString();
		temp2 = temp2.toUpperCase();
		char c = temp.charAt(temp.length());
		if(c != ('.' | '!' | '?')) 
		{
			temp = temp + ".";
		}
		for(int i = 0; i < temp.length(); i++) 
		{
			if(temp.charAt(i) == ' ') 
			{
				if(temp.charAt(i+1) == ' ') 
				{
					temp = temp.substring(0,i) + temp.substring(i+2, temp.length()-1);
				}
			}
		}
		
		String fin = temp2 + temp.substring(1,temp.length()-1);
		return fin;
		
	}

}

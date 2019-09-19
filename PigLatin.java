
public class PigLatin {
	public static String translate (String original){
		char start = Character.toLowerCase(original.charAt(0));
		if ((start == 'a' || start == 'e' || start == 'i' || start == 'o' || start == 'u')) {
			return original + "vai";
		}
		else {
			return original.substring(1) + start + "ai";
		}
		
	}
	public static void main(String[] args){
		//ignored
	}

	
			
				

}

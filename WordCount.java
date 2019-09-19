
public class WordCount {
		public static void main(String[]args) {
			//ignore
		}
	   public static int countWords(String original, int maxLength) {
		   String[] words = original.split(" ");
		   int total = 0;
		   for (String word : words)
		   {
			   if (word.replaceAll("[^a-zA-Z]", "").length() <= maxLength) 
			   {
				   total++;
			   }
		   }
		   return total;
	   }
	   
}
	




	



public class getLongest {
	public static void main(String[]args) {
		String [] names= {"Bob", "Sanders", "KKK ALL DAY", "Hari", "Yellow"};
		String x = getLongest(names);
		System.out.print(x);
	}
	public static String getLongest(String[]names) {
		int i = 0;
		for (i = 0; i<names.length; i++) {
			if (names[i].length() > names[i+1].length()) {
				return (names[i]);
			}
		}
		  return null;
	}
}

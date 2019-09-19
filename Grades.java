
public class Grades {
	public static void add(double[][] array, int exam, int student, double grade) {
		if (array.length >= student && array[student].length >= exam) {
			array[student][exam] = grade;
		}
		else {
			System.out.println("Error: array out of bounds");
		}
	}
	public static void print(double[][]array) {
		for (int r = 0; r < array.length; r++) {
			for (int c = 0; c < array[r].length; c++) {
				System.out.print(array[r][c] + " ");
			}
		}
	}
	public static void studentAverage (double[][] array, int student) {
		double sum = 0.0;
		//make sure that the student index is within the array bound
		if (array.length >= student) {
			for (int c=0; c<array[student].length;c++) {
				sum += array[student][c];
			}
		}
		double avg = sum;
	}
	public static void main(String[] args) {
		//create and populate a 2-D array
		double[][] grades = new double [4][3]; //4 students and 3 exams
		//student 1
		add(grades, 0,0,3.7);
		add(grades, 1,0,6.0);
		add(grades, 2,0,9.2);
		//student 2
		add(grades, 0,1,4.7);
		add(grades, 1,1,8.2);
		add(grades, 2,1,10);
		//student 3
		add(grades, 0,2,5.2);
		add(grades, 1,2,6.7);
		add(grades, 2,2,9.6);
		//student 4
		add(grades, 0,3,7.2);
		add(grades, 1,3,9.2);
		add(grades, 2,3,6.7);
		print(grades);
	}
}

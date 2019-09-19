/* 
 * Defining the blueprint for a Student
 */
public class Student {
	//instance variable 
	int id;
	String name;
	double midterm1, midterm2, finalExam;
	
	//constructor;initializes the object
	public Student (int id, String name) {
		this.id = id;
		this.name = name;
		this.midterm1 = 0.0;
		this.midterm2 = 0.0;
		this.finalExam = 0.0;
		
	}
	//another constructor same name with five arguments
	public Student (int id, String name, double midterm1, double midterm2, double finalExam) {
		this.id = id;
		this.name = name;
		this.midterm1 = 0.0;
		this.midterm2 = 0.0;
		this.finalExam = 0.0;
	}
	//toString method returns the string representation of the object
	public String toString() {
		return this.name + "[" + this.id + "]";
	}
	public double getAverage() {
		return(this.midterm1 + this.midterm2 + this.finalExam)/3;
	}
}

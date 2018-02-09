import java.util.Scanner;


public class Salary {
	public double employeeSalary(double hours) {
		// Space complexity is O(1)
		double salary  = 0;   
		double rate = 15;
		int firstHours = 36;
		int nextHours = 5;
		int maxHours = 48;
		
		// Time complexity is O(1)
		if (hours <= firstHours) {
			salary = rate * hours;
		} else if (hours <= firstHours + nextHours) {
			salary = rate * firstHours + rate *1.5*(hours - firstHours);
		} else if (hours <= maxHours) {
			salary = rate * firstHours + rate*1.5*nextHours + rate*2 *(hours -firstHours-nextHours ) ;
		} else {
			System.out.println("The hour is beyond the maximum");
		}
		return salary;
	}
	public static void main(String[] args) {
		
		System.out.println("Enter worked hours, the maximum is 48: ");
		Scanner scanner = new Scanner(System.in);
		String hours = scanner.nextLine();
		
		System.out.println("The salary is " + new Salary().employeeSalary(Double.parseDouble(hours)));
	}
}

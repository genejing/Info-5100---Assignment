// total scores : 10 / 10

public class Calculator {
	
	public double addition(double a,double b) {
		return a + b;
	}
	
	public double subtraction(double a,double b) {
		return a - b;
	}
	
	public double multiplication(double a,double b) {
		return a * b;
	}
	
	public double division(double a,double b) {
		if (b == 0) {
			throw new ArithmeticException("/ by zero");
		} else {
			return a / b;
		}
	}
	
	public double squareRoot(double a) {
		return Math.sqrt(a);
	}
	
	public double square(double a) {
		return a * a;
	}
	
	public double cube(double a) {
		return a * a * a;
	}
	
	public double toCelsius(double f) {
		return (f - 32) / 1.8;
	}
	
	public double toFahrenheit(double c) {
		return 1.8 * c + 32;
	}
	
	public double toInches(double f) {
		return 12 * f;
	}
	
	public double toFeet(double i) {
		return i / 12;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		Calculator calculator = new Calculator();
		System.out.println(calculator.addition(1, 2));
		System.out.println(calculator.subtraction(1, 2));
		System.out.println(calculator.multiplication(1, 2));
		System.out.println(calculator.division(1, 2));
		System.out.println(calculator.square(5));
		System.out.println(calculator.squareRoot(64));
		System.out.println(calculator.cube(10));
		System.out.println(calculator.toCelsius(41));
		System.out.println(calculator.toFahrenheit(20));
		System.out.println(calculator.toFeet(12));
		System.out.println(calculator.toInches(5));
	}
}

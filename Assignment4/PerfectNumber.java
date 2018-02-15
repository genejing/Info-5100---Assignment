import java.text.StringCharacterIterator;

public class PerfectNumber {
	public void printPerfectNumbers(int n){
		for (int i = 1; i <= n; i++) {
			if (isPerfectNumber(i)) {
				System.out.println(i);
			}
		}
	}
	public boolean isPerfectNumber(int n){
		if (n<=1) return false;
		int sum = 1;
		int i = 2;
		while(i*i<n) {
			if (n%i==0) {
				sum = sum + i + n/i;
			}
			i++;
		}
		if (i*i == n) {
			sum +=n;
		}
		return sum == n;
	}
	
	public static void main(String[] args) {
		new PerfectNumber().printPerfectNumbers(30);
	}
}

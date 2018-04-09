
public class ReverseHello {
	public static void main(String[] args) {
		CreateThread ct = new CreateThread();
		Thread thread = new Thread(ct);
		thread.start();
	}
}
class CreateThread implements Runnable {
	
	static int n = 0;
	
	@Override
	public void run() {
		if (n < 50) {
			n++;
			CreateThread ct = new CreateThread();
			Thread thread = new Thread(ct);
			thread.start();
			try {
				thread.join();
				System.out.println("Hello from Thread " + n);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n--;
		}
		
	}
}

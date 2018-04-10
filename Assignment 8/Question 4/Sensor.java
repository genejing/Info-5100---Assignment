package Assignment8_4;

public class Sensor extends Thread {
	
	private Device device;
	private double value;
	public Sensor(Device device) {
		this.device = device;
	}
	public double getValue() {
		return value;
	}
	public void updateValue() {
		this.value += 0.001;
	}
	public void run() {
		while(true) {
			synchronized (device) {
				updateValue();
				device.notify();
			}
		}
		
	}
}

package Assignment8_4;

public class Controller extends Thread {
	private Device device;
	private Sensor heat;
	private Sensor pressure;
	
	public Controller(Device device, Sensor heat, Sensor pressure) {
		this.device = device;
		this.heat = heat;
		this.pressure = pressure;
	}
	
	public String input(Sensor heat, Sensor pressure) {
		return ("heat -> " + String.format("%.2f", heat.getValue()) + " , pressure -> "+String.format("%.2f", pressure.getValue()));
	}

	public void run() {
		device.startup();
		synchronized (device) {
			while (heat.getValue() <= 70 && pressure.getValue() <= 100) {
				System.out.println(input(heat,pressure));
				try {
					device.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		device.shutdown();
		
		
	}

}

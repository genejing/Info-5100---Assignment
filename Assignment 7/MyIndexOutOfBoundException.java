package Assignment7;

public class MyIndexOutOfBoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int lowerBound;
	private int upperBound;
	private int index;
	
	public MyIndexOutOfBoundException() {
		super();
	}
	
	public MyIndexOutOfBoundException(String s) {
		super(s);
	}
	
	public MyIndexOutOfBoundException(int index,int lowerBound, int upperBound) {
		this.index = index;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.toString();
	}
	
	public String toString() {
		return "Error Message: Index:" + this.index + ",but Lower bound: " +
				this.lowerBound+ ",Upper bound:"+this.upperBound;
	}
	
	public static void main(String[] args) {
		int[] array = new int[6];
		for (int i = 0;i <= 6;i++) {
			if (i < 0 || i >= array.length) {
				throw new MyIndexOutOfBoundException(i,0,array.length-1);
			}
		}
	}
	
	
}

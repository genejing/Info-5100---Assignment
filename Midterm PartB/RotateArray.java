
import java.util.Arrays;

public class RotateArray {
	public void rotetedArray(int nums[], int d, int n) {
		reverse(nums,0,n-1);
		reverse(nums,0,n-1-d);
		reverse(nums,n-d,n-1);
	}
	
	public static void reverse(int nums[],int a,int b) {
		while (a < b) {
			int temp = nums[a];
			nums[a] = nums[b];
			nums[b] = temp;
			a++;
			b--;
		}
	}
	
	public static void main(String[] args) {
		RotateArray ra = new RotateArray();
		int[] nums = {1,2,3,4,5,6,7};
		ra.rotetedArray(nums, 2, 7);
		System.out.println(Arrays.toString(nums));
	}
}

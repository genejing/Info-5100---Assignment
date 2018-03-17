
public class SmallestSubArraySum {
	public static int smallestSubWithSum(int arr[], int x) {
		if (arr == null || arr.length == 0) return -1;
        int left = 0, right = 0;
        int sum = arr[0];
        int min = Integer.MAX_VALUE;
        int count = 1;
        while (right < arr.length) {
            if( sum <= x) {
                right++;
                if (right < arr.length) sum += arr[right];
                count++;
            } else {
                min = Math.min(count,min);
                sum -= arr[left];
                left++;
                count--;
            }
        }
        if (min == Integer.MAX_VALUE) return -1;
        return min;
	}
	
	public static void main(String[] args) {
		
		int[] arr1 = {1,4,45,6,0,19};
		int x1 = 51;
		System.out.println(smallestSubWithSum(arr1, x1));
		
		int[] arr2 = {1,10,5,2,7};
		int x2 = 9;
		System.out.println(smallestSubWithSum(arr2, x2));
		
		int[] arr3 = {1,11,100,1,0,200,3,2,1,250};
		int x3 = 280;
		System.out.println(smallestSubWithSum(arr3, x3));
		
		int[] arr4 = {1,2,4};
		int x4 = 8;
		System.out.println(smallestSubWithSum(arr4, x4));
		
	}
}

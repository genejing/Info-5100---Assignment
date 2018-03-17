
public class FindLongestLength {
	public int findLengthOfLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int left = 0, right = 1;
        int max = 0, count = 1;
        while (right < nums.length) {
            if (nums[left] >= nums[right]) {
                max = Math.max(count,max);
                count = 1;
            } else {
                count++;
            }
            left++;
            right++;
        }
        max = Math.max(count,max);
        return max;
    }
	
	public static void main(String[] args) {
		FindLongestLength fll = new FindLongestLength();
		int[] test1 = {1,3,5,4,7};
		int[] test2 = {2,2,2,2,2};
		System.out.println(fll.findLengthOfLength(test1));
		System.out.println(fll.findLengthOfLength(test2));
		
	}
}

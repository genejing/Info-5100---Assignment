// when result is Not Possible, return -1 

import java.util.Arrays;

public class SearchForRange {
	
	public int[] searchForRange(int[] nums,int target) {
		int[] ans = {-1,-1};
		if (nums == null || nums.length == 0) return ans;
		int left = findLeft(nums, target);
		if (left == -1) return ans;
		int right = findRight(nums,target);
		ans[0] = left;
		ans[1] = right;
		return ans;
	}

	
	private int findLeft(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while(start + 1 < end) {
			int mid = start + (end - start)/2;
			if (nums[mid] >= target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (nums[start] == target) return start;
		if (nums[end] == target) return end;
		return -1;
	}
	
	private int findRight(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start)/2;
			if (nums[mid] <= target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (nums[end] == target) return end;
		if (nums[start] == target) return start;
		return -1;
	}


	public static void main(String[] args) {
		SearchForRange sfr = new SearchForRange();
		System.out.println(Arrays.toString(sfr.searchForRange(new int[] {5,7,7,8,8,10}, 8)));
	}

}

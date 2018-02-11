// you should write the main function to print out the value you got. also, I think there is a logic problem for your code. 
// currently you finish your whole assignments but the code will not work out for several cases.


public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int[] array = nums.clone();
        
        Arrays.sort(array);
        int lo = 0, hi = array.length - 1;
        while (array[lo] + array[hi] != target) {
            if (array[lo] + array[hi] > target) {
                hi--;
            } else {
                lo++;
            }
        }
        boolean used = false;
        for (int i=0; i<nums.length;i++) {
            if (nums[i] == array[lo] && !used) {
                res[0] = i;
                used = true;
            }
            if (nums[i] == array[hi]) res[1] = i;
        }
        return res;
    }
}

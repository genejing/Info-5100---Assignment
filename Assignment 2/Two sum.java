// there is a logic problem about your code, the requirement is the return to the index of the two elements that meet the requirement.

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
                break;
            } else {
                map.put(target-nums[i],i); // i think you should put (nums[i],i) in your hashmap
            }
        }
        return ans;
    }
}

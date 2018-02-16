// please write your main function, or scores will be deducted next time.
// scores : 10 / 10
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;
		int left = 0;
		int right = 0;
		int res = 0;
		Set<Character> set = new HashSet<>();
		while (right < s.length()) {
			if (!set.contains(s.charAt(right))) {
				set.add(s.charAt(right));
				right++;
				res = Math.max(res, set.size());
			} else {
				set.remove(s.charAt(left));
				left++;
			}
		}
		return res;
	}
}

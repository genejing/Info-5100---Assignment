import java.util.Stack;


class Solution {
	public boolean isValid(String s) { 
		if (s == null) return true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (curr=='(' || curr =='{' || curr =='[') {
				stack.push(s.charAt(i));
			} else if(stack.isEmpty()) { 
				return false;
			} else if (curr == ')') {
				if (stack.pop() != '(') {
					return false;
				}
			} else if (curr == '}') {
				if (stack.pop() != '{') {
					return false;
				}
			} else {
				if (stack.pop() != '[') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String test1 = "()"; 
		System.out.println(solution.isValid(test1));
		
		String test2 = "()[]{}";
		System.out.println(solution.isValid(test2));
		
		String test3 = "(]";
		System.out.println(solution.isValid(test3));
		
		String test4 = "([)]";
		System.out.println(solution.isValid(test4));
		
		
	}
}

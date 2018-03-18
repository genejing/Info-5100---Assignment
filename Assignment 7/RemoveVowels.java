package Assignment7;

import java.util.HashSet;
import java.util.Set;


public class RemoveVowels {
	public String removeVowelsFromString(String input) {
		if (input == null) return input;
		StringBuilder res = new StringBuilder("");
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		for (int i = 0; i < input.length(); i++) {
			if (!set.contains(input.charAt(i))) {
				res.append(input.charAt(i));
			}
		}
		return res.toString();
	}
}

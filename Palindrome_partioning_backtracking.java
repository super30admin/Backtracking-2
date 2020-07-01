
//Time Complexity: O(N * 2^N)
//Space Complexity: O(2^N)
//Have trouble Understanding? : NOt able to understand the space complexity
import java.util.*;

public class Palindrome_partioning_backtracking {
	List<List<String>> result;

	public List<List<String>> partition(String s) {
		result = new ArrayList<>();
		if (s == null || s.length() == 0)
			return result;
		backtrack(s, new ArrayList<>(), 0);
		return result;
	}

	private void backtrack(String s, List<String> temp, int start) {
		// base
		if (start == s.length()) {
			result.add(new ArrayList<>(temp));
			return;
		}
		// logic
		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				// action
				temp.add(s.substring(start, i + 1));
				// recurse
				backtrack(s, temp, i + 1);
				// backtrack
				temp.remove(temp.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int start, int end) {
		if (start == end)
			return true;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}
import java.util.ArrayList;
import java.util.List;


/*
 * The Time complexity of the code is exponential.
 * and by using backtracking we have reduced space complexity.
 * but because of substring it will be O(n).
 */

public class PalindromePartitioning {

	List<List<String>> result;

	public List<List<String>> partition(String s) {

		result = new ArrayList<>();

		if (s == null || s.length() == 0)
			return result;

		backtrack(s, 0, new ArrayList<>());

		return result;

	}

	private void backtrack(String s, int index, List<String> path) {

		if (index == s.length()) {

			result.add(new ArrayList<>(path));
			return;
		}

		for (int i = index; i < s.length(); i++) {

			if (isPalindrome(s, index, i)) {

				path.add(s.substring(index, i + 1));

				// recurse

				backtrack(s, i + 1, path);

				path.remove(path.size() - 1);

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

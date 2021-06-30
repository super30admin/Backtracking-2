// Time Complexity : O(N* 2 POW N) // at every node we can take 2 decisions.
// Space Complexity :O(N* 2 POW N) //temporary array which we are making a copy to add it to result
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


/*
 * 1. DP for loop with backtracking 
 * 2. Select each element and go to next element and find all possible combinations and add it to result.
 * 3. move to next element till all elements are completed. 
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	List<List<String>> result;

	public List<List<String>> partition(String s) {
		result = new ArrayList<>();
		helper(s, 0, new ArrayList<String>());
		return result;
	}

	private void helper(String s, int index, List<String> path) {
		// base
		if (index==s.length()) {
			result.add(new ArrayList<String>(path));
			return;
		}

		// logic
		for (int i = index; i < s.length(); i++) {
			if (isPalindrome(s, index, i)) {
				// act
				path.add(s.substring(index, i + 1));
				// recur
				helper(s, i + 1, path);
				// backtrack
				path.remove(path.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) != s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}
	public static void main(String[] args) {
		new PalindromePartitioning().partition("aab");
	}
}

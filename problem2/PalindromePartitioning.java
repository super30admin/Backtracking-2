//Time Complexity : O(n*(2^n)), n -> Size of string
// Space Complexity : O(n*(2^n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	List<List<String>> ans;

	public List<List<String>> partition(String s) {
		ans = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return ans;
		}

		helper(s, 0, new ArrayList<>());

		return ans;
	}

	/***********************************************************************
	 * Backtrack after adding each character to check all subset combinations
	 ***********************************************************************/
	private void helper(String s, int index, List<String> subset) {
		// Base
		if (index >= s.length()) {
			ans.add(new ArrayList<String>(subset));
		}
		// Logic
		for (int i = index; i < s.length(); i++) {
			String str = s.substring(index, i + 1);
			if (isPalindrome(str)) {
				subset.add(str);
				helper(s, i + 1, subset);
				subset.remove(subset.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i++) != str.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePartitioning obj = new PalindromePartitioning();
		String s = "aab";
		List<List<String>> ans = obj.partition(s);

		System.out.println("Set of palindrome substrings: ");
		for (List<String> subset : ans) {
			for (String str : subset) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}

}

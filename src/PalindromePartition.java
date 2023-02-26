import java.util.ArrayList;
import java.util.List;
//Time Complexity : O(2^N)
//Space Complexity : O(N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Apply backtracking. Start iterating from 0th index of the string. fetch the
 * substring from start to end (which starts from start to length of the string)
 * and check if it is palindrome. If so, add it to the list of palindrome
 * strings and then call Backtracking from next index. To cover all
 * possibilities, we have to drop the last added palidrom from the list. Add all
 * these lists when the end of the string is reached.
 *
 */
class Solution {
	List<List<String>> ans = new ArrayList<>();

	public List<List<String>> partition(String s) {
		helper(s, 0, new ArrayList<>());
		return ans;
	}

	public void helper(String s, int start, List<String> list) {
		if (start >= s.length()) {
			ans.add(new ArrayList<>(list));
			return;
		}

		for (int end = start; end < s.length(); end++) {
			if (isPalindrome(s, start, end)) {
				list.add(s.substring(start, end + 1));
				helper(s, end + 1, list);
				list.remove(list.size() - 1);
			}
		}
	}

	public boolean isPalindrome(String s, int i, int j) {
		while (i <= j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
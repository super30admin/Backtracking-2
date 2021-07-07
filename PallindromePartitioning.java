

import java.util.*;
//Time Complexity : O(N * 2^N)
//Space Complexity : O(2^N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
/*
* Backtracking Approach is used for exploring all possibilities for pallindrome substring 
* 
* */

public class PallindromePartitioning {
	List<List<String>> output = new ArrayList<>();

	public List<List<String>> partition(String s) {
		if (s.length() == 0 || s.isEmpty() || s == null || "".equals(s)) {
			return output;
		}
		backtrack(s, new ArrayList<>(), 0);
		return output;
	}

	public void backtrack(String word, List<String> list, int index) {
		if (index == word.length()) {
			output.add(new ArrayList<>(list));
			return;
		} else {
			int size = word.length();
			for (int i = index; i < size; i++) {
				if (isPallindrome(word, index, i)) {
					list.add(word.substring(index, i + 1));
					backtrack(word, list, i + 1);
					list.remove(list.size() - 1);
				}
			}
		}
	}

	public boolean isPallindrome(String word, int left, int right) {
		while (left < right) {
			if (word.charAt(left) != word.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
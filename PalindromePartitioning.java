// Time - O(n 2 ^ n) 
// Space - O(n)

class Solution {
	public List<List<String>> partition(String s) {
		List<List<String>> solution = new ArrayList<>();
		List<String> state = new ArrayList<>();
		backtrack(solution, state, s, 0);
		return solution;
	}

	private void backtrack(List<List<String>> solution, List<String> state, String s, int start) {

		// calls are made if current token is palindrome
		// isGoal?
		if(start == s.length()) {
			solution.add(new ArrayList<>(state));
			return;
		}

		// fan out for loop
		for(int end = start; end < s.length(); end++) {
			// if palindrome(start ... end)
			if(isPalindrome(s, start, end)) {
				// add current token: s[start .. end]
				// [ [..] [.. ]] c.t[start .. end] | end + 1
				state.add(s.substring(start, end + 1));
				backtrack(solution, state, s, end + 1);
				state.remove(state.size() = 1);
			}
		}
	}

	// isPalindrome
	private boolean isPalindrome(String s, int start, int end) {
		while(start <= end) {
			is(s.charAt(start) != s.charAt(end)) {
				return false;
			}

			start++;
			end--;
		}
		return true;
	}
}
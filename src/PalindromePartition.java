// Time Complexity : backtracking O(n*2^n)
// Space Complexity : backtracking O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

public class PalindromePartition {
	List<List<String>> res;
	public List<List<String>> partition(String s) {
		res = new ArrayList<>();

		if(s == null || s.length() ==0) return res;

		helper(s, new ArrayList<>(), 0);
		return res;
	}

	//backtracking solution, time - 
	private void helper(String s, List<String> temp, int index) {

		//base
		if( index == s.length()) {
			res.add(new ArrayList<>(temp));
			return;
		}

		//logic
		for(int i=index; i< s.length(); i++) {
			if(isPalindrome(s, index, i)) {
				//action
				temp.add(s.substring(index, i+1));

				//recurse
				helper(s, temp, i+1);
				temp.remove(temp.size()-1);
			}
		}
	}

	private boolean isPalindrome(String s, int l, int r){

		if( l == r) return true;

		while( l < r) {
			if(s.charAt(l) != s.charAt(r)) return false;
			l++;r--;
		}
		return true;
	}
}

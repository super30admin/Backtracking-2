// TC : O(N * pow(2, N)) since we are generating n combinations for n elements
// SC : O(n *(2^n)) since we are using recursion stack space for combinations

// I am generating every possible substring and checking if it is a palindrome or not. If it is a palindrome, I will add that string onto temporary list. once we reach end of the String, we add that temporary list that we got
// which has palindromic substrings, we add it to our resulting list.  we then trackback the recursion once we have reached end of the string and check for other valid palindromic substring combinations


import java.util.*;

public class palindromePartition {

	public List<List<String>> palindrome(String s){
		
		List<List<String>> res = new ArrayList<>();
		
		if(s == null || s.length() == 0)
			return res;
		
		backTracking(s, res, new ArrayList(), 0);
		return res;
		
	}
	
	public void backTracking(String s, List<List<String>> res, List<String> temp, int st) {
		
		if(st == s.length())
			res.add(new ArrayList<>(temp));
		
		for(int i = st; i < s.length();i++) {
			
			String check = s.substring(st, i+1);
			if(isPalindrome(check)) {
				temp.add(check);
				backTracking(s, res, temp, i+1);
				temp.remove(temp.size()-1);
			}
		}
			
	}
	
	public boolean isPalindrome(String s) {
		
		int i = 0, j = s.length()-1;
		while(i<=j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		palindromePartition pp = new palindromePartition();
		System.out.println(pp.palindrome("cbcb"));
	}
}

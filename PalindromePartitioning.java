

// Time Complexity : Exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


import java.util.*;
public class PalindromePartitioning {
	
	List<List<String>> res;

	private List<List<String>> partition(String s) {
		
	
		if (s == null || s.length() == 0)
			return res;
		
		res = new ArrayList<>();

		backTrack(s, new ArrayList<>(), 0);

		for (List<String> l : res) {
			System.out.println(l);
		}

		return res;
		
        
    }
	
	
	
	private void backTrack(String s, List<String> temp, int index) {
		
		if(s.length() == index) {
			res.add(new ArrayList<>(temp));
		}
		
		for(int i=index; i< s.length(); i++) {
			if(isPalindrome(s,index,i)){
				temp.add(s.substring(index,i+1));
				backTrack(s, temp, i+1);
				temp.remove(temp.size()-1);
			}
		}
		
	}
	
	private boolean isPalindrome(String s, int l, int r) {
		
		
		while(l<r) {
			char x = s.charAt(l);
			char y = s.charAt(r);
			if(x != y) {
				return false;
				
			}
			l++; r--;
		}
		
		
		
		return true;
	}
	
	public static void main(String[] args) {
		
		PalindromePartitioning p = new PalindromePartitioning();
		p.partition("aacaadbb");
		
		

	}

}

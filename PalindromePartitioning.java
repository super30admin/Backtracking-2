package s30Coding;

import java.util.*;

//Time Complexity :- O(n*2^n)
//Space Complexity :- O(n)

//LeetCode :- backtrack and check if it is palindrome or not
public class PalindromePartitioning {
	 List<List<String>> result;
	    public List<List<String>> partition(String s) {
	        result = new ArrayList<>();
	        if(s == null || s.length() == 0) return result;
	        backtrack(s, new ArrayList<String>(), 0);
	        return result;
	    }
	    private void backtrack(String s,List<String> temp, int start){
	       if(start == s.length()){
	           result.add(new ArrayList<String> (temp));
	       } 
	        for(int i = start; i < s.length(); i++){
	            if(isPalindrome(s,start,i)){
	                temp.add(s.substring(start,i+1));
	                backtrack(s,temp,i+1);
	                temp.remove(temp.size() -1);
	            }
	        }
	    }
	    private boolean isPalindrome(String s, int l , int r){
	        
	        if(l == r) return true;
	        while(l < r){
	            if(s.charAt(l) != s.charAt(r)) return false;
	            l++; r--;
	        }
	        return true;
	        
	    }
}

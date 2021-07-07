//Time complexity is O(2^n*n) as we are two choices and n is the time for checking wheather it is palindrome or not. 
//space complexity is O(n) i.e the number of element (Recursive stack space).
//This solution is submitted on leetcode

import java.util.ArrayList;
import java.util.List;

public class BigN71PalindromeSubstring {
	    List<List<String>> result = new ArrayList<>();
	    public List<List<String>> partition(String s) {
	    	//edge case
	        if(s==null || s.length()==0)
	            return result;
	        backtrack(s,0, new ArrayList<String>());
	        return result;
	        
	    }
	    private void backtrack(String s, int index, List<String> temp){
	        // base case
	        if(index==s.length()){
	            result.add(new ArrayList<>(temp));
	            return;
	        }
	        // logic
	        for(int i =index;i<s.length();i++){
	            if(isPalindrome(s,index,i)){
	                temp.add(s.substring(index,i+1));
	                backtrack(s,i+1,temp);
	                temp.remove(temp.size()-1);
	            } 
	        }
	    }
	    private boolean isPalindrome(String s , int l, int r){
	        while (l<r){
	            if(s.charAt(l)!=s.charAt(r)) return false;
	            l++;
	            r--;
	        }
	        return true;
	    }
	}
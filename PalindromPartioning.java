import java.util.ArrayList;
import java.util.List;
//Time Complexity : O(N * 2^N) where N is the length of String (N is from substring and 
//palindrome check, 2^N is from recursion )
//Space Complexity :O(N) where N is the length of decoded String 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :

public class PalindromPartioning {
	  
	   List<List<String>> result = new ArrayList<>();
	    
	    public List<List<String>> partition(String s) {
	        
	        helper(s,0,new ArrayList<>());
	        
	        return result;
	    }
	    
	    public void helper(String s, int idx, List<String> path){
	        // base case 
	         if(idx==s.length()){
	             result.add(new ArrayList<>(path));
	             return;
	         }
	        // logic
	            for(int i=idx;i<s.length();i++){
	                String str = s.substring(idx,i+1);
	                if(!isPalindrome(str))
	                    continue;
	                path.add(str);
	                helper(s,i+1,path);
	                path.remove(path.size()-1);
	            }
	        
	        }
	    
	    
	    public boolean isPalindrome(String s){
	        int left = 0;
	        int right  = s.length()-1;
	        while(left<=right){
	            char l = s.charAt(left);
	            char r = s.charAt(right);
	            if(l!=r)
	                return false;
	            left++;
	            right--;
	        }
	        
	        return true;
	    }
	    
}

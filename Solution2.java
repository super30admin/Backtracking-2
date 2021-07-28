//Time complexity: O(N*(2^N)), where N is the length of s.
//Space complexity: O(N)

import java.util.*;

class Solution2 {
    List<List<String>> result; 
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        helper(s, 0, new ArrayList<>()); 
        return result;
    }
    
    private void helper(String s, int start, List<String> path) {
        //base case
        if(start == s.length())
            result.add(new ArrayList<>(path)); 
        
        //logic
        for(int i=start; i<s.length(); i++) {
            String str = s.substring(start, i+1);
            //if the string is palindrome
            if (isPalindrome(str)) {
                //add
                path.add(str);
                //recurse 
                helper(s, i + 1, path);
                //backtrack
                path.remove(path.size()-1); 
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        int start = 0, end = str.length()-1;
        while(start < end) {
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true; 
    }
}

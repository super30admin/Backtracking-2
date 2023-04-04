
 // Time Complexity : 2 ^ n
// Space Complexity : 2 ^ n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Run a for loop for each element and check if the substring is palindrome. 
Substring runs from pivot to i, so it can consider different values
Add the new string to path and add it to result at the end. 

*/


public class Problem2 {
    List<List<String>> result ;
        public List<List<String>> partition(String s) {
            result = new ArrayList<>();
            helper(s, 0, new ArrayList<>());
            return result;
    }
    private void helper(String s, int idx, List<String> path){
        if(idx == s.length()){
                result.add(new ArrayList<>(path));
                return;
            }
        for(int i = idx; i < s.length(); i++){
            String subStr = s.substring(idx, i+1);
            if(isPalindrome(subStr)){
            path.add(subStr);
            helper(s, i+1, path);
            path.remove(path.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int start = 0; 
        int end = s.length() - 1; 
        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end --;
        }
        return true;
    }
}

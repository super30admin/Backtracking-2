// 131. Palindrome Partitioning - https://leetcode.com/problems/palindrome-partitioning/
// Time Complexity : Exponential
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<List<String>>();
        if(s == null || s.length() == 0)
            return result;
        
        helper(s, 0, new ArrayList<String>());
        return result;
    }
    
    private void helper(String s, int index, List<String> path){
        //base
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int l, int r){
        if(l == r)
            return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}
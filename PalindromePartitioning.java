// Time Complexity : O(n!)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    For pivot element we would need to explore all the substrings possible henceforth.
    For the pivot at 1 -> there would be (n-1) options
    For the pivot at 2 -> there would be (n-2) options 
    .
    .
    .
    Hence time complexity would be (n-1*)(n-2)*(n-3).. = O(n!)
*/

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        
        result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        
        backtrack(s, new ArrayList<>(), 0);
        
        return result;
    }
    
    public void backtrack(String s, List<String> path, int index) {
        
        if (index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i=index; i<s.length(); i++){
            if (isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                backtrack(s, path, i+1);                
                path.remove(path.size()-1);
            }
        }
        
    }
    
    private boolean isPalindrome(String s, int l, int r){
        
        while (l<=r){
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;   
    }
    
}
// Time Complexity : O(n*(2^n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        //null case
        if(s == null || s.length() == 0) return result;
        backtrack(s, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(String s, int index, List<String> path){
        //base
        if(s.length() == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=0; i<s.length(); i++){
            if(isPalindrome(s, 0, i)){
                //action
                path.add(s.substring(0, i+1));
                //recurse
                backtrack(s.substring(i+1), 0, path);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }
    //palindrome check function
    private boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            else { l++; r--; }
        }
        return true;
    }
}
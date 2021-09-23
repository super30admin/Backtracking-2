// Time Complexity : O(2^n)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Recursion
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }
    private void helper(String s, int index, List<String> path){
        // base 
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                // action
                List<String> newList = new ArrayList<>(path);
                newList.add(s.substring(index, i+1));
                // path.add(s.substring(index, i+1));
                // recursion
                helper(s, i+1, newList);
                //backtracking
                // path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
// ****************************************

// Backtracking
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }
    private void helper(String s, int index, List<String> path){
        // base 
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                // action
                path.add(s.substring(index, i+1));
                // recursion
                helper(s, i+1, path);
                //backtracking
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
// ****************************************

// substring approach
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, new ArrayList<>());
        return result;
    }
    private void helper(String s, List<String> path){
        // base 
        if(s.length() == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for(int i=0; i<s.length(); i++){
            if(isPalindrome(s, 0, i)){
                // action
                // List<String> newList = new ArrayList<>(path);
                // newList.add(s.substring(index, i+1));
                path.add(s.substring(0, i+1));
                helper(s.substring(i+1), path);
                // recursion
                // helper(s, i+1, newList);
                //backtracking
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
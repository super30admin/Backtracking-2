// Time Complexity: O(n*2^n)
// Space Complexity: O(n)
// Successfully ran on leetcode

// Backtracking

class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        backtrack(s,new ArrayList<String>(),0);
        return res;
    }
    
    private void backtrack(String s,List<String> temp, int start) {
        if(start==s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<s.length();i++) {
            if(isPalindrome(s,start,i)) {
                // action
                temp.add(s.substring(start,i+1));
                // recurse
                backtrack(s,temp,i+1);
                // backtrack
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int l, int r){
        if(l==r) return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}

// Recursive Solution

class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        helper(s,new ArrayList<String>(),0);
        return res;
    }
    
    private void helper(String s,List<String> temp, int start) {
        if(start==s.length()) {
            res.add(temp);
            return;
        }
        for(int i=start;i<s.length();i++) {
            if(isPalindrome(s,start,i)) {
                List<String> newList = new ArrayList<>(temp);
                newList.add(s.substring(start,i+1));
                helper(s,newList,i+1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int l, int r){
        if(l==r) return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
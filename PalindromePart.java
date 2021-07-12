
// Time Complexity: O(n * 2^n)
// Space Complexity : recursion Call Stack O(n)
// Did this code successfully run on Leetcode : yes


class Solution {
   
List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        backtrack(s, new ArrayList<>());
        return result;
    }
    
    
    
    private void backtrack(String s, List<String> path) {
        //Base
        if(s.length() == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        //Logic
        for(int i = 0 ; i < s.length() ; i++) {
            if(isPalindrome(s, 0, i)) {
                List<String> copy = new ArrayList<>();
                //action
                path.add(s.substring(0, i + 1));
                //recurse
                backtrack(s.substring(i + 1), path);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}


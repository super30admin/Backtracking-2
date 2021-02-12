// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        helper(s, 0, new ArrayList<>());
        return res;
    }

    private void helper (String s, int idx, List<String> path){
        //base
        if(idx == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = idx; i < s.length(); i++){
            if(isPalindrome(s,idx,i)){
            //action
            path.add(s.substring(idx, i+1));
            //recurse
            helper(s,i+1,path);
            //backtrack
            path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high){
        if(low == high) return true;
        while(low < high){
            if(s.charAt(low) != s.charAt(high)) return false;
            low++; high--;
        }
        return true;
    }
}
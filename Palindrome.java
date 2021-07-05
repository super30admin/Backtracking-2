// Time Complexity :  O(N * 2^N) no of elements
// Space Complexity : O(N) - worst case stack adding all elements
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        backtrack(0 , s, new ArrayList<>());
        return res;
    }
    private void backtrack(int start, String s, List<String> curr){
        if(start >= s.length()) res.add(new ArrayList<>(curr));
        
        //logic
        
        for(int i = start; i < s.length(); i++){
            //String temp = s.substring(0, i);
            if(isPal(s, start, i)){
                curr.add(s.substring(start, i + 1));
                backtrack(i + 1, s, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private boolean isPal(String s, int i , int j){
        if(s.length() == 1) return true;
        while( i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}

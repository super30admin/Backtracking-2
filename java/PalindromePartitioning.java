// Time Complexity : exponential
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s==null || s.length()==0) return res;
        helper(s, 0, new ArrayList<>());
        return res;
    }

    private void helper(String s, int start, List<String> path){
        //base
        if(start>=s.length())
            res.add(new ArrayList<>(path));
        //logic
        for(int end=start; end<s.length(); end++){
            if(isPalindrome(s, start, end)){
                path.add(s.substring(start, end+1));
                helper(s, end+1, path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}
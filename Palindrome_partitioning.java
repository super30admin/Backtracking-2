// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        if(s==null || s.length() == 0){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        recurse(s, 0 , new ArrayList<>());
        return res;
    }
    private void recurse(String s, int index, List<String> path){
        //base
        if(index == s.length()){
            res.add(path);
        }

        //logic
        for(int i = index; i<s.length(); i++){
            if(isPalindrome(s,index, i)){
                List<String> l = new ArrayList<>(); 
                l.add(s.substring(index, i+1));
                recurse(s,i+1, l);
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }   
        return true;
    }
}
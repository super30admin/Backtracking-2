// Time Complexity : [Exponential] O(2 ^ N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }
        backtrack(s, 0, new ArrayList<String>());
        return result;
        
    }
    private void backtrack(String s, int index, List<String> temp){
        if(index == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                //action
                temp.add(s.substring(index, i+1));
                //recurse
                backtrack(s, i + 1, temp);
                //backtrack
                temp.remove(temp.size() - 1);
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
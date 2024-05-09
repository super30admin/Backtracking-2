// Time Complexity : O(2^n)
// Space Complexity : O(N) - stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path){

        // base case
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for(int i = pivot;i< s.length();i++){
            String substr = s.substring(pivot, i+1);
            if(isPalindrome(substr)) {
                path.add(substr);
                helper(s,i+1, path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start =0;
        int end = s.length()-1;

        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
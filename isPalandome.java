// Time Complexity : O(2^n * n)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, 0, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, int i, int size, List<String> path){
        if(i == s.length()){
            if(size == s.length()){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        //no choose
        helper(s, pivot, i+1, size, path);

        //choose
        String subStr = s.substring(pivot, i+1);
        if(isPalindrome(subStr)){
            //action
            path.add(subStr);
            //recurse
            helper(s, i+1, i+1, size + subStr.length(), path);
            //backtrack
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }
}

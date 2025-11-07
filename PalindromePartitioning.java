// Time Complexity : O(2^(n) * n) where n is the length of String s.
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Approach : I followed for loop recursion with backtracking to get the result. For each substring from pivot to i we each if it is a palindrome and then
// proceed ahead.Once the pivot reaches the end of the string we add it to the result, backtrack it and continue the checks with the rest of the substring.


class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path){
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=pivot; i<s.length(); i++){
            String subStr = s.substring(pivot, i+1);
            if(isPalindrome(subStr)){ //check if it is palindrome
                path.add(subStr);
                helper(s, i+1, path);//recurse
                path.remove(path.size() - 1);//backtracking
            }
        }
    }

    private boolean isPalindrome(String s){
        int start = 0, end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

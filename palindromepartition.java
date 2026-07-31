// Time Complexity : O(2^n) where n is the length of the input string. This is because for each character in the string, we have two choices: either to include it in the current partition or not, leading to a binary tree of possibilities.
// Space Complexity : O(n) where n is the length of the input string. This is the space required to store the recursion stack and the resulting partitions.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding the backtracking approach for generating all possible partitions.
// Your code here along with comments explaining your approach : used backtracking to generate all possible partitions of the input string. For each substring, we check if it is a palindrome. If it is, we add it to the current path and recursively call the helper function with the remaining substring. When we reach the end of the string, we add the current path to the result list.
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, new ArrayList<>());
        return result;
    }

    private void helper(String s, List<String> path){
        if(s.length() == 0){
            result.add(new ArrayList<>(path));
            return; 
        }
        for(int i=0; i<s.length(); i++){
            String subStr = s.substring(0, i+1);
            if(isPalindrome(subStr)){
                path.add(subStr);
                helper(s.substring(i+1), path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++; 
            right--;
        }
        return true;
    }
}


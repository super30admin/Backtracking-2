// Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

// Time Complexity : O(n x 2^n)
// Space Complexity : O(n x 2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, fix pivot at 0 first and while recursion, loop from i = pivot to end. and if the substring from pivot to i is a 
 * palindrome then add substring to path from pivot to i+1 which is till i, and then recurse again with pivot i+1 and remove the
 * last element of path that is backtract and when pivot reaches length of string add path to the result and finally return the
 * result.
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(s, 0, path, result);
        return result;
    }
    private void helper(String s, int pivot, List<String> path, List<List<String>> result){
        //base
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = pivot; i<s.length();i++){
            if(isPalindrome(s, pivot, i)){
                path.add(s.substring(pivot, i+1));
                helper(s, i+1, path, result);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
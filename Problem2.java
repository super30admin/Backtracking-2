// https://leetcode.com/problems/palindrome-partitioning/
// Time Complexity : O(n* 2^n) where n is the length of the input string. 
//                  This is because in the worst case, we can have 2^n possible partitions of the string, 
//                  and for each partition, we need to check if it is a palindrome, which takes O(n) time.
// Space Complexity : O(n^ 2) where n is the length of the input string. 
//                    This is because we need to store all possible partitions, 
//                    and each partition can have up to n strings of length up to n.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;
    }

    private void helper(String s, List<String> path, List<List<String>> result){
        // base case 
        if(s.length() == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = 0; i< s.length(); i++){
            String currStr = s.substring(0, i+1);
            if(isPalindrome(currStr)){
                //action
                path.add(currStr);
                //recurse
                helper(s.substring(i+1), path, result);
                //backtrack
                path.remove(path.size() -1);
            }
        }

    }
    private boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i<j){
           if(s.charAt(i++) != s.charAt(j--)){
            return false;
           }
        }
        return true;
    }
}
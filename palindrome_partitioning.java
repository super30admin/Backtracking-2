// Time Complexity : O(n * 2^n) because we explore all possible partitions and palindrome checking takes O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use backtracking to try every possible substring starting from the current pivot index and only continue recursion if the substring is a palindrome.
// When the pivot reaches the end of the string, it means a valid palindrome partition is formed, so we add a deep copy of the current path into the result.
// Backtracking removes the last chosen substring after recursion so that other possible palindrome partition combinations can be explored correctly.

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result; 
    }

    private void helper(String s, int pivot, List<String> path, List<List<String>> result) {
        // base
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < s.length(); i++) {
            String curr = s.substring(pivot, i+1);

            if (isPalindrome(curr)) {
                // action
                path.add(curr);

                // recurse
                helper(s, i+1, path, result);

                // backtrack
                path.remove(path.size()-1);

            }    
        }
    }

    boolean isPalindrome(String s) {
        int i = 0; 
        int j = s.length()-1;
        while (i<=j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
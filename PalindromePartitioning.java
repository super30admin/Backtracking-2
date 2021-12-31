// Time Complexity : exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach 

// We see that for each candidate we have two choices, to partition or not
// we write the iterative recursive approach for the same
// we expand on it by doing the backtracking i.e remove the element that doesnt give the answer
// we also check if the curr partition is palindrome or not if ues then we move to the next partition
class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;

        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int index, List<String> currPartitions) {

        if (index == s.length()) {
            result.add(new ArrayList(currPartitions));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String part = s.substring(index, i + 1);
            if (isPalindrome(part)) {
                currPartitions.add(part);
                helper(s, i + 1, currPartitions);
                currPartitions.remove(currPartitions.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
// Time Complexity : exponential
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach

// We see that for each candidate we have two choices, to partition or not
// we write the iterative recursive approach for the same
// we expand on it by doing the backtracking i.e remove the element that doesnt
// give the answer
// we also check if the curr partition is palindrome or not if ues then we move
// to the next partition
// we use dp to reduce the calculations for checking the substring to be
// palindrome
class Solution {
    List<List<String>> result;
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j + i < s.length(); j++) {
                int end = j + i;
                dp[j][end] = s.charAt(j) == s.charAt(end) && isPalindrome(s, j + 1, end - 1);
            }
        }
        helper(s, 0, new ArrayList<>());
        return result;
    }

    boolean isPalindrome(String s, int start, int end) {
        if (start > end)
            return true;
        return dp[start][end];
    }

    private void helper(String s, int index, List<String> currPartitions) {

        if (index == s.length()) {
            result.add(new ArrayList(currPartitions));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String part = s.substring(index, i + 1);
            if (isPalindrome(s, index, i)) {
                currPartitions.add(part);
                helper(s, i + 1, currPartitions);
                currPartitions.remove(currPartitions.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
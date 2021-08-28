//https://leetcode.com/problems/palindrome-partitioning/
/*
Time: O(N.2^N) where N is the length of the string s
Space: O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {

        if (s == null || s.length() == 0)
            return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;

    }

    private static void helper(String s, List<String> subResult, List<List<String>> result) {
        if (s.isEmpty() || s.length() == 0) {
            result.add(new ArrayList<>(subResult));
            return;
        }

        for (int i = 1; i <= s.length(); i++) // start from 1
        {
            String leftPartition = s.substring(0, i);

            if (isPalindrome(leftPartition)) // left is a palindrome
            {
                subResult.add(leftPartition); // choose
                String rightPartition = s.substring(i, s.length());
                helper(rightPartition, subResult, result); // explore
                subResult.remove(subResult.size() - 1); // unchoose
            }

        }
    }

    private static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l <= r && s.charAt(l) == s.charAt(r)) // keep going until charAt(l) == charAt(r)
        {
            l++;
            r--;
        }

        return l >= r;
    }

}

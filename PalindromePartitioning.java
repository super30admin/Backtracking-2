//Time Complexity: O(N * 2 ^ N) -> N for palindrome check, 2 ^ N for backtracking
//Space Complexity: O(N) depth of the tree

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        final List<List<String>> output = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), output);

        return output;
    }

    private void backtrack(String s, int pivot, List<String> combo, List<List<String>> output) {
        if (pivot == s.length()) {
            output.add(new ArrayList<>(combo));
            return;
        }

        for (int i = pivot; i < s.length(); i++) {
            String current = s.substring(pivot, i + 1);
            if (isPalindrome(current)) {
                //action
                combo.add(current);
                //recurse
                backtrack(s, i + 1, combo, output);
                //backtrack
                combo.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        final PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        System.out.println(palindromePartitioning.partition("aaba"));
        System.out.println(palindromePartitioning.partition("abcdad"));
        System.out.println(palindromePartitioning.partition("a"));
        System.out.println(palindromePartitioning.partition("aaaa"));
    }
}

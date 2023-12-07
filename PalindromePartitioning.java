// Time complexity : O(n * 2^n)
// Space complexity : O(n)

import java.util.*;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "abaa";
        List<List<String>> result = partition(s);
        System.out.println(result);
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void helper(String s, int pivot, List<String> path, List<List<String>> result) {
        // base
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for (int i = pivot; i < s.length(); i++) {
            String sub = s.substring(pivot, i + 1);
            if (isPalindrome(sub)) {
                // action
                path.add(sub);
                // recurs
                helper(s, i + 1, path, result);
                // backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

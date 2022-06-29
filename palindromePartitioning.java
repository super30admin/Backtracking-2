// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    private static List<List<String>> result;

    public static List<List<String>> partition(String s) {
        result = new ArrayList<>();
        // null case
        if (s.length() == 0)
            return result;
        // helper function
        helper(0, s, new ArrayList<>());
        return result;

    }

    private static void helper(int ind, String s, List<String> path) {
        // base case
        if (ind == s.length()) {
            // add path into the result
            result.add(new ArrayList<>(path));
            return;
        }

        // main logic
        for (int i = ind; i < s.length(); i++) {
            // substring from ind to i+1 for each level
            String sb = s.substring(ind, i + 1);
            // check if it is palindrome then we go further or we are not going further
            if (isPalindrome(sb)) {
                // if is palindrome we add it to the path and move pivot by 1
                path.add(sb);
                helper(i + 1, s, path);
                // backtrack
                path.remove(path.size() - 1);
            }
        }
        // result.add(new ArrayList<>(path));
    }

    // check palindrome or not
    private static boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaba";
        System.out.println(partition(s));

    }
}
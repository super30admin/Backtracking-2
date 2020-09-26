// Time Complexity :O(2^N * N) 
//O(2^N) for either choosing or not choosing the character
//O(N) for checking whether the string is palindrome or not
// Space Complexity :O(N) where N =length of the result List
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//At each instance check whether the string is a palindrome or not.
//If yes then add it to the path and continue.
// Using backtracking would traverse each substring of the given string 
import java.util.*;

public class PalindromePartitioning {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return result;

        backtracking(s, 0, new ArrayList<>(), result);

        return result;
    }

    public void backtracking(String s, int index, List<String> path, List<List<String>> result) {
        // base
        if (index == s.length()) {
            result.add(path);
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(index, i))) {
                List<String> p = new ArrayList<>(path);
                p.add(s.substring(index, i));
                backtracking(s, i, p, result);
            }
        }
    }

    public boolean isPalindrome(String str) {
        int n = str.length() - 1;
        int m = 0;
        while (m < n) {
            if (str.charAt(m++) != str.charAt(n--))
                return false;
        }

        return true;
    }

    public static void main(String args[]) {
        PalindromePartitioning obj = new PalindromePartitioning();
        String s = "aaab";
        System.out.println(obj.partition(s));
    }
}

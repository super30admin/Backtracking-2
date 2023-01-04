import java.util.*;

public class Palindrome_partitioning {

    // Approach: Check if substring palindrome, if yes - action, recurse, backtrack
    // Time: O(N*2^N)
    // Space: O(N)
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();

        helper(result, 0, new ArrayList(), s);
        return result;
    }

    void helper(List<List<String>> result, int start, List<String> currentList, String s) {

        if (start == s.length()) result.add(new ArrayList(currentList));

        for (int end = start; end<s.length(); end++) {
            if (isPalindrome(s, start, end)) {                      // if palindrome
                currentList.add(s.substring(start, end+1));         // action
                helper(result, end+1, currentList, s);              // recurse
                currentList.remove(currentList.size() - 1);         // backtrack
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}

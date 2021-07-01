import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Puri
 * // Time Complexity : O(2^n)
 * // Space Complexity : O(2^n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> outer = new ArrayList<>();
        List<String> inner = new ArrayList<>();

        findans(outer, inner, s, 0);
        return outer;
    }

    private void findans(List<List<String>> outer, List<String> inner, String s, int idx) {

        if (idx == s.length()) {
            outer.add(new ArrayList<>(inner));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                inner.add(s.substring(idx, i + 1));
                findans(outer, inner, s, i + 1);
                inner.remove(inner.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {

        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}
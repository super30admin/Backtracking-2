import java.util.ArrayList;
import java.util.List;

// Time complexity:O(N*2^N) N is length of string.
// Space complexity:O(N)
public class Palindrome {
    List<List<String>> pal = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return pal;
        helper(s, 0, new ArrayList<>());
        return pal;
    }

    private void helper(String s, int index, ArrayList<String> path) {
        if (index == s.length()) {
            pal.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            end--;
            start++;
        }
        return true;
    }
}

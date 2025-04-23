import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return res;
    }

    private void helper(String s, int pivot, List<String> path) {
        //base
        if (pivot == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < s.length(); i++) {
            String sb = s.substring(pivot, i + 1);
            if (isPalindrome(sb)) {
                path.add(sb);
                helper(s, i + 1, path);
                path.removeLast();
            }
        }

    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

//TC: O(n * 2^n), SC: O(n)

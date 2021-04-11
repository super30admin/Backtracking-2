import java.util.ArrayList;
import java.util.List;
//tc : O(m * n)
//sc: O(n)
public class PartitionPalindrome {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return res;

        backtracking(s, 0, new ArrayList<>());
        return res;
    }
    private void backtracking(String s, int index, List<String> path) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String curr = s.substring(index, i + 1);
            if (isPalindrome(curr)) {
                path.add(curr);
                backtracking(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }

    }
    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}

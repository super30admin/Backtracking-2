import java.util.*;

class Solution {
    // Tc: O(n*2^n) Sc: O(n*2^n)
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return res;

    }

    private void helper(String s, int index, List<String> path) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (isPalin(sub)) {
                path.add(sub);
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalin(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

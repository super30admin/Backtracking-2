// Time Complexity: O(N * 2^N)
// Space Complexity: O(N)

import java.util.*;

public class LC131 {
    List<List<String>> ans = new ArrayList<>();

    private boolean isPalindrome(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private void recurse(String s, int idx, int n, List<String> list) {
        // BC
        if (idx == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // Logic
        for (int i = idx; i < n; i++) {
            if (!isPalindrome(s, idx, i))
                continue;
            String substr = s.substring(idx, i + 1);
            list.add(substr);
            recurse(s, i + 1, n, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return ans;
        }
        recurse(s, 0, s.length(), new ArrayList<>());
        return ans;
    }
}

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<String>());
        return result;
    }

    public void helper(String s, int pivot, ArrayList<String> path) {
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < s.length(); i++) {
            String sub = s.substring(pivot, i + 1); // Corrected method name to "substring"
            if (isPalindrome(sub)) {
                path.add(sub);
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String sub) {
        int start = 0, end = sub.length() - 1;
        while (start < end) {
            char s = sub.charAt(start); // Corrected variable name from "s" to "sub"
            char e = sub.charAt(end); // Corrected variable name from "s" to "sub"

            if (s != e)
                return false;

            start++;
            end--;
        }
        return true;
    }
}


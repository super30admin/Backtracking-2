import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        palindromeRecursion(s, 0, path);
        return result;
    }

    private void palindromeRecursion(String str, int index, List<String> path) {
        // Base case
        if (index == str.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Recursive case
        for (int i = index; i < str.length(); i++) {
            String substring = str.substring(index, i + 1);
            if (isPalindrome(substring)) {
                path.add(substring);
                palindromeRecursion(str, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
 
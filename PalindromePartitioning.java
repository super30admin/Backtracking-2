import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();

        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path) {
        // base
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
        }

        // logic

        for (int i = pivot; i < s.length(); i++) {
            String sub = s.substring(pivot, i + 1);
            if (isPalindrome(sub)) {
                path.add(sub);
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
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

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();

        String s = "aab";

        List<List<String>> result = palindromePartitioning.partition(s);
        System.out.println("Palindrome Partitions: " + result);
    }
}

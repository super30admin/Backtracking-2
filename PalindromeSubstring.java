import java.util.ArrayList;
import java.util.List;

// TC: O(2^n * n) where n is the length of the input. it checks palindrome for every subset which happens n times.
// SC: O(h) where h is the height of the recursion stack. in the worst case, it can be O(n).

// backtracking approach is used here to iterate the possibilities of the strings
public class PalindromeSubstring {
    static List<List<String>> output;

    public static void main(String[] args) {
        partition("aabcdaza");
        for (List<String> out : output) {
            System.out.println(out);
        }
    }

    private static void partition(String s) {
        output = new ArrayList<>();
        if (s == null || s.length() == 0)
            return;
        dfs(s, 0, new ArrayList<>());
        return;
    }

    private static void dfs(String s, int index, List<String> current) {
        if (index == s.length()) {
            output.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                current.add(s.substring(index, i + 1));
                dfs(s, i + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }

    // Helper method to check for palindrome
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;

        }
        return true;

    }

}
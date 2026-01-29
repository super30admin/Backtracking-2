import java.util.ArrayList;
import java.util.List;
/*
 * TIME COMPLEXITY:
 * Exponential in worst case (many partitions, e.g., "aaaa...").
 * Plus palindrome checks which cost up to O(n) each.
 *
 * SPACE COMPLEXITY:
 * Recursion depth O(n) + output size.
 */

public class PalindromePartitioning {
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();

        // Pick ONE:
        forLoopHelper(s, 0, new ArrayList<>());          // for-loop based
        //chooseNoChooseHelper(s, 0, 0, new ArrayList<>()); // choose / no-choose based

        return res;
    }

    //  FOR-LOOP BASED
    public void forLoopHelper(String s, int start, List<String> path) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String sub = s.substring(start, end + 1);
            if (isPalindrome(sub)) {
                path.add(sub);                 // choose
                forLoopHelper(s, end + 1, path); // recurse
                path.remove(path.size() - 1);  // backtrack
            }
        }
    }

    // CHOOSE / NO-CHOOSE BASED
    // State: (start, end)
    // - noChoose: extend end
    // - choose: cut at [start..end] if palindrome, then restart at next index
    public void chooseNoChooseHelper(String s, int start, int end, List<String> path) {
        // If we've partitioned the whole string
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // If end reached beyond string, cannot extend further
        if (end == s.length()) return;

        // NO-CHOOSE: don't cut yet, extend the substring
        chooseNoChooseHelper(s, start, end + 1, path);

        // CHOOSE: cut here if palindrome
        String sub = s.substring(start, end + 1);
        if (isPalindrome(sub)) {
            path.add(sub);
            // next substring starts at end+1; end resets to end+1
            chooseNoChooseHelper(s, end + 1, end + 1, path);
            path.remove(path.size() - 1); // backtrack
        }
    }

    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    // TESTS
    public static void main(String[] args) {
        PalindromePartitioning sol = new PalindromePartitioning();
        System.out.println("For-loop based: " + sol.partition("aab"));

        PalindromePartitioning sol2 = new PalindromePartitioning();
        sol2.res = new ArrayList<>();
        sol2.chooseNoChooseHelper("aab", 0, 0, new ArrayList<>());
        System.out.println("Choose/No-Choose: " + sol2.res);
    }
}

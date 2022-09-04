import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        // at each and every node we have to take partitions
        result = new ArrayList<>();

        if (s == null || s.length() == 0)
            return result;

        helper4(s, 0, 0, new ArrayList<>());
        return result;

    }

    // for loop based recursion from index onwards
    // initial partition between pivot and i
    // at each and every place string we are generating we are checking if it's
    // palindrome or not
    // if string generated at that path is not palidrome we dont add it to the list
    // dont do the recursion further
    // At each and every node we can have a new Arraylist as path or we can use
    // backtracking
    public void helper1(String s, int idx, List<String> path) {
        // base
        if (idx == s.length()) {
            // when index goes out of bounds it means all substring have been created and
            // they are palindromes
            result.add(new ArrayList<>(path));
            return;
        }
        // Pivot onwards
        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            // if substring is not a palindrome we don't perform the recursion and loop
            // moves ahead
            if (isPalindrome(sub)) {
                path.add(sub);
                helper1(s, i + 1, path);
                path.remove(path.size() - 1);
            }

        }
    }

    // Instead of changing the pivot we pass the substring, pivot will always be the
    // 0th character
    public void helper2(String s, List<String> path) {
        if (s.length() == 0) {
            // when index goes out of bounds it means all substring have been created and
            // they are palindromes
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (isPalindrome(sub)) {
                path.add(sub);
                helper2(s.substring(i + 1, s.length()), path);
                path.remove(path.size() - 1);
            }

        }
    }

    // for loop with backtracking
    public void helper3(String s, int idx, List<String> path) {
        if (idx == s.length()) {
            // when index goes out of bounds it means all substring have been created and
            // they are palindromes
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            if (isPalindrome(sub)) {
                List<String> temp = new ArrayList<>(path);
                temp.add(sub);
                helper3(s, i + 1, temp);

            }

        }
    }

    // choose not choose
    public void helper4(String s, int idx, int i, List<String> path) {
        // base
        if (idx == s.length()) {
            // when index goes out of bounds it means all substring have been created and
            // they are palindromes
            result.add(new ArrayList<>(path));
            return;
        }
        if (i == s.length())
            return;
        // logic
        // dont choose
        helper4(s, idx, i + 1, path);
        // choose
        String sub = s.substring(idx, i + 1);
        if (isPalindrome(sub)) {
            path.add(sub);
            helper4(s, i + 1, i + 1, path);
            path.remove(path.size() - 1);
        }

    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        // till the time they don't cross each other
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }
}

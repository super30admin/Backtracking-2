import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {

        String s = "aab";
        PalindromePartitioning obj = new PalindromePartitioning();
        List<List<String>> obj1 = obj.partition(s);
        System.out.println(obj1);

    }

    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, 0, new ArrayList<>());
        return result;

    }

    private void helper(String s, int pivot, int i, List<String> path) {

        // base
        if (pivot == s.length()) {

            result.add(new ArrayList<>(path));
            return;
        }
        if (i == s.length())
            return;

        // logic
        // action
        // for (int i = pivot ; i < s.length() ; i ++){
        // not choose
        helper(s, pivot, i + 1, path);
        String s1 = s.substring(pivot, i + 1);

        if (isPolindrime(s1)) {
            path.add(s1);

            // recurse
            helper(s, i + 1, i + 1, path);
            // backtracking
            path.remove(path.size() - 1);
        }
    }

    public boolean isPolindrime(String s) {
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
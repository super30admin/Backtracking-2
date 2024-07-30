public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(s, 0, path, result);
        return result;
    }

    private void helper(String s, int pivot, List<String> path, List<List<String>> result) {

        // base
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < s.length(); i++) {
            String sub = s.substring(pivot, i + 1);
            if (isPalindrome(sub)) {
                // action
                path.add(sub);
                // recurse
                helper(s, i + 1, path, result);
                // backtrack
                path.remove(path.size() - 1);

            }

        }

    }

    private boolean isPalindrome(String s) {
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
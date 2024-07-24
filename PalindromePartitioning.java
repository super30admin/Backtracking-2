// Time Complexity : O(l * 2^l)
// Space Complexity : O(l)

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result;

    }

    private void helper(String s, int pivot, List<String> path, List<List<String>> result) {
        // base
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        for (int i = pivot; i < s.length(); i++) {
            String currsub = s.substring(pivot, i + 1);

            if (isPalindrome(currsub)) {
                // action
                path.add(currsub);
                // recurse
                helper(s, i + 1, path, result);
                // backtrack
                path.remove(path.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0)
            return false;

        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }
}
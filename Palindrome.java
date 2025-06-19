// Time complexity O(2^n)
// Space Complexity O(n) recursive stack
// Runs on LeetCode YES
class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<List<String>>();
        helper(s, 0, new ArrayList<String>());
        return result;
    }

    private void helper(String s, int pivot, ArrayList<String> path) {

        // base
        if (pivot == s.length()) {
            result.add(new ArrayList(path));
            return;
        }

        for (int i = pivot; i < s.length(); i++) {

            String curr = s.substring(pivot, i + 1);

            if (isPalindrom(curr)) {
                path.add(curr);

                helper(s, i + 1, path);

                path.remove(path.size() - 1);
            }
        }

    }

    private boolean isPalindrom(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (r >= l) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
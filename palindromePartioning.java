/*
TC --> O(2^n)
Sc --> O(n)
 */
class Solution {

    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        Helper(s, 0, new ArrayList<>());
        return res;

    }

    public void Helper(String s, int idx, List<String> path) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;

        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                path.add(s.substring(idx, i + 1));
                Helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            if (c1 != c2) {
                return false;
            }
            start++;
            end--;

        }//while
        return true;

    }
}

class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int start, List<String> path) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String substring = s.substring(start, end + 1);
            if (isPalindrome(substring)) {
                path.add(substring); // ACTION
                backtrack(s, end + 1, path); // RECURSE
                path.remove(path.size() - 1); // BACKTRACK
            }
        }
    }

    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }
}

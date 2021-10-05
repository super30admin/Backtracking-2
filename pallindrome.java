class pallindrome {
    // TC: O(2^n) SC: O(n)
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;

    }

    private void helper(String s, int index, List<String> path) {
        // base
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for (int i = index; i < s.length(); i++) {
            if (isPallindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));

                helper(s, i + 1, path);

                // backtrack
                path.remove(path.size() - 1);

            }
        }
    }

    private boolean isPallindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        if(s == "" || s.length() == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        backtrack(s, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, List<String> path) {
        // base
        if(s.length() == 0) {
            result.add(new ArrayList<>(path));
        }

        // logic
        for(int i = 0; i < s.length(); i++) {
            if(isPalindrome(s, 0, i)) {
                path.add(s.substring(0, i + 1));

                backtrack(s.substring(i+1), path);

                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while(l <= r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

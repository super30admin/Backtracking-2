class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();

        result = new ArrayList<>();
        List<String> currList = new ArrayList<>();
        backtrack(s, 0, currList);

        return result;
    }

    private void backtrack(String s, int idx, List<String> currList) {

        if (idx == s.length()) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int j = 1; j <= s.length() - idx; j++) {

            if (isPalindrome(s.substring(idx, idx+j))) {

                currList.add(s.substring(idx, idx+j));
                backtrack(s, idx+j, currList);
                currList.remove(currList.size() - 1);

            }

        }

    }

    private boolean isPalindrome(String s) {

        int l = s.length();
        for (int i=0; i<l/2; i++) {
            if (s.charAt(i) != s.charAt(l - i - 1)) return false;
        }
        return true;

    }
}

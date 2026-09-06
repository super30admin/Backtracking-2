//time complexity O(2^n* n) 
//space complexity o(n2) for string creation and stack space

// dfs with a backtracking and a for loop
class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {

        helper(s, 0, new ArrayList<>());
        return result;

    }

    private void helper(String s, int index, List<String> path) {

        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int j = index; j < s.length(); j++) {

            String currString = s.substring(index, j + 1);

            if (isValidPalindrome(currString)) {

                path.add(currString);
                helper(s, j + 1, path);

                path.remove(path.size() - 1);

            }
        }
    }

    private boolean isValidPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
}

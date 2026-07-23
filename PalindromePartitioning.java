class Solution {
    /*
        TC - O(n * 2^n) -
        n is the length of the input string,
        2^n is the number of possible partitions, and n is for copying the list to the result
        SC - O(n) - for the recursion stack
        Solution uses backtracking to generate all possible palindrome partitions of the string.
        Starting from the current pivot index, generate every possible substring s[pivot...i]. 
        If the substring is a palindrome, it is added to the current path, and recursion continues from the next index.
        After returning, the substring is removed (backtracking) to explore other paths.
        When pivot == s.length(), the entire string has been partitioned, so the current partition is copied into 
        the result.
    */
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, new ArrayList<>(), 0);
        return result;
    }

    public void helper(String s, List<String> path, int pivot) {
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
        }

        for (int i = pivot; i < s.length(); i++) {
            String curr = s.substring(pivot, i + 1);
            if (isPalindrome(curr)) {
                path.add(curr);
                helper(s, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
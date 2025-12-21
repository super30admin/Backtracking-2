// Time Complexity: O(n * 2^n) in the worst case, n = length of the string
// Space Complexity: O(n) for recursion stack + O(total partitions) for result
// 1. Use DFS/backtracking to explore all possible partitions of the string.
// 2. For each substring, check if it is a palindrome before adding to the current path.
// 3. Add the current path to the result when the end of the string is reached and backtrack.

class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, new ArrayList<>(), 0);
        return result;
    }

    private void helper(String s, List<String> path, int pivot) {
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < s.length(); i++) {
            String curr = s.substring(pivot, i + 1);
            if (isPalindrome(curr)) {
                path.add(curr);
                helper(s, path, i + 1);
                path.remove(path.size() - 1); // backtrack
            }
        }
    }

    private boolean isPalindrome(String curr) {
        int i = 0, j = curr.length() - 1;
        while (i < j) {
            if (curr.charAt(i) != curr.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

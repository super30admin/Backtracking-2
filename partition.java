// time complexity - O(n * 2^n)
// Space complexity - O(n)

/* Approach : This solution uses backtracking to partition the input string into all possible sets of 
palindrome substrings. The process starts with an empty path and recursively explores all possible substrings. 
For each substring, it checks if it is a palindrome. If it is, the substring is added to the current path, 
and the function recurs with the remaining part of the string. This continues until the entire string is 
processed. If the end of the string is reached, the current path (which contains a valid partition) is added 
to the result. The function then backtracks by removing the last added substring to explore other potential 
partitions. This ensures that all possible palindrome partitions are found. The isPalindrome helper function 
is used to check if a substring is a palindrome by comparing characters from both ends towards the center.
 */
class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        // If the input string is empty, return the empty result list
        if (s.length() == 0) return result;

        // Start the recursive helper function with an empty path
        helper(s, new ArrayList<>());

        return result;
    }

    private void helper(String s, List<String> path) {
        // Base case: if the string is empty, add the current path to the result
        if (s.length() == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Iterate through the string to create substrings
        for (int i = 0; i < s.length(); i++) {
            String curr = s.substring(0, i + 1);
            // Check if the current substring is a palindrome
            if (isPalindrome(curr, 0, curr.length() - 1)) {
                // Choose the current substring
                path.add(curr);
                // Recur with the remaining substring
                helper(s.substring(i + 1), path);
                // Backtrack: remove the last added substring
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        // Check if the substring is a palindrome
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

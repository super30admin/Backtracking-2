/*
For Loop based Recursion

Time Complexity:
O(2^n * n), where n is the length of the string s.
There are O(2^n) possible subsets (since we can include or exclude each character in a partition).
For each subset, we perform a check for palindromes which takes O(n) time.
Space Complexity:
O(n), where n is the length of the string s.
The recursive stack depth will go up to n (in the worst case, if the function explores the string character by character), and each recursive call requires space for a temporary list temp.

The partition function uses backtracking to find all valid partitions where each substring is a palindrome.
For each potential substring, it checks if it's a palindrome using isPalindrome; if true, it adds it to the current partition and recursively explores further substrings.
The recursion explores all combinations of palindromic substrings, and the result is stored in a list, which is returned at the end.
 */

 class Solution {
    List<List<String>> result;  // This will hold all the valid palindrome partitions

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();  // Initialize the result list to store the partitions
        backtrack(s, 0, new ArrayList<>());  // Start backtracking from index 0 with an empty temporary list
        return result;  // Return the final list of all valid partitions
    }

    private void backtrack(String s, int start, List<String> temp) {
        // Base case: If we've reached the end of the string
        if (start >= s.length()) {
            result.add(new ArrayList<>(temp));  // Add the current partition (temp) to result
            return;  // Terminate this recursive path
        }

        // Logic: Try every possible substring starting from index `start`
        for (int i = start; i < s.length(); i++) {
            // Check if the current substring is a palindrome
            if (isPalindrome(s, start, i)) {
                // If it is, add it to the current partition
                temp.add(s.substring(start, i + 1));
                // Recurse with the next part of the string (starting at index i + 1)
                backtrack(s, i + 1, temp);
                // Backtrack: Remove the last added substring (undo the choice)
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        // Check if the substring from index `l` to `r` is a palindrome
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;  // If characters don't match, it's not a palindrome
            l++; r--;  // Move towards the center
        }
        return true;  // If no mismatch, it's a palindrome
    }
}


/*
01 Based Recursion

Time Complexity:
O(2^n * n), where n is the length of the string s.

There are O(2^n) possible subsets of the string (because each character can either be included or excluded).
For each subset, checking whether it's a palindrome takes O(n) time, where n is the length of the substring.
Space Complexity:
O(n), where n is the length of the string s.

The maximum recursion depth will be n, and the space used by the recursive call stack is proportional to this depth.
The temporary list path holds at most n elements, resulting in O(n) space usage at each recursive step.

The partition method generates all possible partitions of the string where each substring is a palindrome.
The backtracking function explores all possible substrings and checks if they are palindromes; if they are, it recursively partitions the remaining string.
The solution backtracks by removing the last palindrome substring and explores other possible partitions until all possibilities are explored.
 */


 class Solution {

    List<List<String>> result;  // List to store all the valid palindrome partitions.

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();  // Initialize the result list.
        helper(s, 0, 0, new ArrayList<>());  // Start backtracking from index 0 with an empty path.
        return result;  // Return the result containing all valid palindrome partitions.
    }

    private void helper(String s, int pivot, int i, List<String> path) {
        // Base case: When `i` reaches the end of the string.
        if (i == s.length()) {
            // If `pivot` is also at the end, it means we've considered the entire string.
            if (pivot == s.length()) {
                result.add(new ArrayList<>(path));  // Add the current partition to the result.
            }
            return;  // Terminate the recursive call.
        }

        // Logic: Try both options (don't choose or choose) at each step.
        
        // Option 1: Don't choose the current substring, move to the next index.
        helper(s, pivot, i + 1, path);

        // Option 2: Choose the current substring and check if it's a palindrome.
        String sub = s.substring(pivot, i + 1);
        if (isPalindrome(sub)) {
            // If it is a palindrome, add it to the current partition.
            path.add(sub);
            // Recurse by moving the pivot forward and start from the next position (`i+1`).
            helper(s, i + 1, i + 1, path);
            // Backtrack: Remove the last added substring and explore other options.
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        // Helper function to check if a string is a palindrome.
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;  // Return false if characters at start and end don't match.
            }
            start++;
            end--;
        }
        return true;  // Return true if the string is a palindrome.
    }
}
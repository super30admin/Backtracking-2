class Solution {
    // Main method to partition the string into all possible palindromic substrings
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>(); // List to store all the palindromic partitions
        helper(0, s, new ArrayList<>(), result); // Start the recursive helper function
        return result; // Return the result
    }

    // Helper method to check if a given string is a palindrome
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        // Check characters from both ends moving towards the center
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) // If characters don't match, it's not a palindrome
                return false;
            start++;
            end--;
        }
        return true; // If all characters match, it's a palindrome
    }

    // Recursive helper method to generate palindromic partitions
    private void helper(int pivot, String s, List<String> path, List<List<String>> result) {
        // Base case: If pivot reaches the end of the string, add the current path to the result
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
        }

        // Iterate over the substring starting from the pivot to the end of the string
        for (int i = pivot; i < s.length(); i++) {
            String currSub = s.substring(pivot, i + 1); // Extract substring from pivot to i
            // If the current substring is a palindrome
            if (isPalindrome(currSub)) {
                path.add(currSub); // Add the current substring to the path
                helper(i + 1, s, path, result); // Recurse with the next pivot (i+1)
                path.remove(path.size() - 1); // Backtrack: remove the last added substring
            }
        }
    }
}

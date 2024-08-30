class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        // If we've reached the end of the string, add the current partition to the result list
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        // Explore all possible substrings starting from 'start' index
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            // Check if the substring is a palindrome
            if (isPalindrome(substring)) {
                // Include the palindrome substring in the current partition
                currentPartition.add(substring);
                // Recur for the remaining substring
                backtrack(s, end, currentPartition, result);
                // Backtrack: Remove the last added substring and explore the next option
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
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

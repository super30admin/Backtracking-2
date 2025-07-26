//TC-O(n * 2^n)
//SC-O(n * 2^n) (result) + O(n) 
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(String s, int start, List<String> path, List<List<String>> result){
         if (start == s.length()) {
            result.add(new ArrayList<>(path)); // Add current path to result
            return;
        }
        if (start == s.length()) {
            result.add(new ArrayList<>(path)); // Add current path to result
            return;
        }

        // Try all substrings starting from current index
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (isPalindrome(prefix)) {
                path.add(prefix);                       // Choose
                backtrack(s, end, path, result);        // Explore
                path.remove(path.size() - 1);           // Backtrack
            }
        }
    }

    // Utility function to check if a string is a palindrome
    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    }
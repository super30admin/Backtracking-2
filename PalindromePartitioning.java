// Time Complexity : O(2^n * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will use backtracking to find all the possible combinations of palindromic substrings.
//  We will start from the first character and keep adding characters to the current path until we reach the end of the string.
//  If the current path is a palindrome, we will add it to the result list and continue to find the next palindrome substring. We will backtrack by removing the last character from the path and continue to find the next palindrome substring.
// We will use a helper function to check if a given substring is a palindrome or not.
//  We will use two pointers to compare the characters from the start and end of the substring until they meet in the middle. If any characters do not match, we will return false. If all characters match, we will return true.
// The time complexity of this solution is O(2^n * n) because in the worst case, we will have to explore all possible combinations of substrings, which is 2^n, and for each combination, we will check if it is a palindrome, which takes O(n) time. The space complexity is O(n) because in the worst case, we will have to store all the characters in the path list, which can be at most n characters long.
import java.util.*;

class Solution {

    List<List<String>> res;

    public List<List<String>> partition(String s) {

        res = new ArrayList<>();

        helper(s, new ArrayList<>(), 0);

        return res;
    }

    private void helper(String s, List<String> path, int pivot) {

        if (pivot == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < s.length(); i++) {

            String subStr = s.substring(pivot, i + 1);

            if (isPalindrome(subStr)) {

                path.add(subStr);

                helper(s, path, i + 1);

                path.remove(path.size() - 1);
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
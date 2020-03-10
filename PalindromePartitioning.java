// Time Complexity : O(2^n); n : length of string
// Space Complexity : O(n) : same list containing atmost n elements will be reused.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : Backtracking
// Need to check if substring till the given index is palindrome or not. If yes proceed to checking the rest of the string.
// If not, increment index, and check for the next substring.
// While backtracking, remove the last element.

class Solution {
    public List<List<String>> partition(String s) {
        // result list
        List<List<String>> result = new ArrayList<>();
        // edge case
        if(s == null || s.length() == 0) return result;
        // backtrack
        backtrack(s, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(String s, List<List<String>> result, List<String> temp, int index) {
        // base case : add temp in result only when end of string is reached
        if(index >= s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // continue recursing only if current substring is a palindrome
        // otherwise backtrack :  remove last element from temp list
        for(int i = index; i < s.length(); i++) {
            String str = s.substring(index,i+1);
            if(isPalindrome(str)) {
                temp.add(str);
                backtrack(s, result, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    // function to check palindrome
    private boolean isPalindrome(String str) {
        int i = 0, j = str.length()-1;
        while(i <= j) {
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}


// Time Complexity : O(N*2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        helper(0, result, new ArrayList<String>(), s);
        return result;
    }

    void helper(int start, List<List<String>> result, List<String> currentList, String s) {
        if (start >= s.length())
          result.add(new ArrayList<String>(currentList));
      
        for (int end = start; end < s.length(); end++) {
            // check if the current string is a palindrome
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));
                helper(end + 1, result, currentList, s);
                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}

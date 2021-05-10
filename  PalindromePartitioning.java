// Time Complexity : exponential
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: 
// consider one character then two uptil n characters and each time 
// recursing with the same for other characters

class Solution {
  List<List<String>> result;

  public List<List<String>> partition(String s) {
    result = new ArrayList<>();
    if (s == null || s.length() == 0)
      return result;
    backtrack(s, 0, new ArrayList<>());
    return result;
  }

  private void backtrack(String s, int index, List<String> temp) {
    if (index == s.length()) {
      result.add(new ArrayList<>(temp));
      return;
    }
    for (int i = index; i < s.length(); i++) {
      if (isPalindrome(s, index, i)) {
        temp.add(s.substring(index, i + 1));
        backtrack(s, i + 1, temp);
        temp.remove(temp.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right))
        return false;
      left++;
      right--;
    }
    return true;
  }
}

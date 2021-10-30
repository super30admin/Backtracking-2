// Time Complexity :O( n * 2 ** n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {

  public List<List<String>> partition(String s) {
    List<List<String>> output = new ArrayList<>();
    if (s == null || s.length() == 0) return output;
    backtrack(output, 0, s, new ArrayList<>()); // TODO
    return output;
  }

  //  to avoid checking for palindrome everytime - kind of memoisation
  private HashSet<String> set = new HashSet<>();

  private List<List<String>> backtrack(
    List<List<String>> output,
    int index,
    String s,
    List<String> path
  ) {
    // all the elements have been processed
    if (index >= s.length()) {
      output.add(new ArrayList<>(path));
      return output;
    }
    for (int i = index; i < s.length(); i++) {
      //In this problem, the enttire string has to be processed together, we can't skip elements
      String curr = s.substring(index, i + 1);
      //if the substring is already present on the hashset, it is already a palindrome. If it's a new substring
      //we need to pass to the isPalindrome function  to  check if its a palindrome
      if (set.contains(curr) || isPalindrome(curr)) {
        path.add(curr);
        backtrack(output, i + 1, s, path);
        path.remove(path.size() - 1);
      }
    }
    return output;
  }

  //Palindrome logic
  private boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) return false;
      left++;
      right--;
    }
    //if the string is a palindrome, we add it to a hashset
    set.add(s);
    return true;
  }
}
//we can use a hashset to avoid running the palindrome function everytime
//but the contains method for hashset wont be O(1) for String. The runtime will
//increase

//edge cases: same letter repeated even or odd number of times
//constraints: none, just return all possible combinations

// for loop based recurssion
// normal recurssion

//characters individually form a palindrome
//tc: O(n*2^n)
//sc:O(n)

class Solution {

  List<List<String>> result;

  public List<List<String>> partition(String s) {
    result = new ArrayList<>();
    helper(s, 0, new ArrayList<>());
    return result;
  }

  private void helper(String s, int pivot, List<String> temp) {
    //base
    if (pivot >= s.length()) {
      result.add(new ArrayList<>(temp));
      return;
    }

    //logic
    for (int i = pivot; i < s.length(); i++) {
      if (isPalindrome(s, pivot, i)) {
        temp.add(s.substring(pivot, i + 1));
        helper(s, i + 1, temp);
        temp.remove(temp.size() - 1);
      }
    }
  }

  public boolean isPalindrome(String subset, int l, int r) {
    if (l == r) return true;
    while (l < r) {
      if (subset.charAt(l) != subset.charAt(r)) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }
}

//edge cases: same letter repeated even or odd number of times
//constraints: none, just return all possible combinations

// for loop based recurssion
// normal recurssion

//characters individually form a palindrome
//tc: O(n*2^n)
//sc:O(n)

class Solution {

  List<List<String>> result;

  public List<List<String>> partition(String s) {
    result = new ArrayList<>();
    helper(s, 0, 0, new ArrayList<>());
    return result;
  }

  private void helper(String s, int pivot, int i, List<String> path) {
    // base

    if (i == s.length()) {
      if (pivot == s.length()) {
        result.add(new ArrayList<>(path));
      }

      return;
    }

    //logic

    //dont choose

    helper(s, pivot, i + 1, path);

    //choose

    String sub = s.substring(pivot, i + 1);

    if (isPalindrome(sub)) {
      //action

      path.add(sub);

      //recurse

      helper(s, i + 1, i + 1, path);

      //backtrack

      path.remove(path.size() - 1);
    }
  }

  //normal 01 recurssion
  private boolean isPalindrome(String s) {
    int start = 0;

    int end = s.length() - 1;

    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) return false;

      start++;

      end--;
    }

    return true;
  }
}

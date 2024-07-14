// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Recursive
/*class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        recurse(s, 0, new ArrayList<>());
        return result;
    }

    void recurse(String s, int index, List<String> path) {
        // Base
        if(index == s.length()) {
            result.add(path);
            return;
        }
        // Logic
        for(int i = index; i<s.length(); i++) {
            String sub = s.substring(index, i+1);
            if(isPalindrome(sub)) {
                List<String> newList = new ArrayList<>(path);
                newList.add(sub);
                recurse(s, i+1, newList);
            }

        }
    }

    boolean isPalindrome(String sub) {
        int left = 0;
        int right = sub.length()-1;
        while(left<=right) {
            if(sub.charAt(left)!=sub.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}*/

// Backtrack
class Solution {
  List<List<String>> result;
  public List<List<String>> partition(String s) {
    result = new ArrayList<>();
    //if(s == null || s.length() == 0) return result;
    backtrack(s, 0, new ArrayList<>());
    return result;
  }

  void backtrack(String s, int index, List<String> path) {
    // Base
    if(index == s.length()) {
      result.add(new ArrayList<>(path));
      return;
    }
    // Logic
    for(int i = index; i<s.length(); i++) {
      String sub = s.substring(index, i+1);
      if(isPalindrome(sub)) {
        path.add(sub);
        backtrack(s, i+1, path);
        path.remove(path.size()-1);
      }
    }
  }

  boolean isPalindrome(String sub) {
    int left = 0;
    int right = sub.length()-1;
    while(left<=right) {
      if(sub.charAt(left)!=sub.charAt(right)) return false;
      left++;
      right--;
    }
    return true;
  }
}
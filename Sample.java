// Problem 1 - Subsets
// Time Complexity: O(n^n)
// Space Complexity: O(n) -> recursive stack

// Algorithm
// 1 - call backtracking with initial values
// 2 - add the list to output
// 3 - loop over nums array starting from index
// 4 - add the num to path
// 5 - call backtracking
// 6 - remove last element from path
class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    // 1
    backtracking(output, nums, 0, path);

    return output;
  }

  private void backtracking(List<List<Integer>> output, int[] nums, int index, List<Integer> path) {
    // 2
    output.add(new ArrayList<>(path));
    // 3
    for (int i=index; i<nums.length; i++) {
      // 4
      path.add(nums[i]);
      // 5
      backtracking(output, nums, i + 1, path);
      // 6
      path.remove(path.size() - 1);
    }
  }
}

// Problem 2 - Palindrome Partitioning
// Time Complexity: O(n^n)
// Space Complexity: O(n) -> recursive stack

// Algorithm
// 1 - call backtracking with initial values
// 2 - base condition - if out of bounds, add to output
// 3 - loop over string starting from index
// 4 - check for palindrome
// 5 - if yes, add the substring to path
// 6 - call backtracking
// 7 - remove last element from path
class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> output = new ArrayList<>();
    List<String> path = new ArrayList<>();
    // 1
    backtracking(output, s, 0, path);

    return output;
  }
  
  private void backtracking(List<List<String>> output, String s, int index, List<String> path) {
    // 2
    if (index >= s.length()) {
      output.add(new ArrayList<>(path));
      return;
    }
    // 3
    for (int i=index; i<s.length(); i++) {
      // 4
      if (isPalindrome(s, index, i)) {
        // 5
        path.add(s.substring(index, i + 1));
        // 6
        backtracking(output, s, i + 1, path);
        // 7
        path.remove(path.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int i, int j) {
    if (i == j) {
      return true;
    }

    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }

      i++;
      j--;
    }

    return true;
  }
}

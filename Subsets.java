// Time Complexity : O(2^n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
  List<List<Integer>> result;

  public List<List<Integer>> subsets(int[] nums) {
    result = new ArrayList<>();
    if (nums == null || nums.length == 0)
      return result;

    helper(nums, new ArrayList<>(), 0);

    return result;
  }

  private void helper(int[] nums, List<Integer> temp, int index) {
    result.add(new ArrayList<>(temp));

    for (int i = index; i < nums.length; i++) {
      temp.add(nums[i]);

      helper(nums, temp, i + 1);
      temp.remove(temp.size() - 1);
    }
  }
}

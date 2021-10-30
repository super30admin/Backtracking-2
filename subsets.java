// Time Complexity :O( n * 2 ** n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    if (nums == null || nums.length == 0) return output;
    backtrack(output, 0, nums, new ArrayList<>()); //TODO
    return output;
  }

  private List<List<Integer>> backtrack(
    List<List<Integer>> output,
    int index,
    int[] nums,
    List<Integer> temp_list
  ) {
    //an empty set is also a subset, so we  have to consider empty as our root
    output.add(new ArrayList<>(temp_list));
    for (int i = index; i < nums.length; i++) {
      temp_list.add(nums[i]);
      //same element can't be  added, so the index changes to i + 1
      backtrack(output, i + 1, nums, temp_list);
      //we trackback our current choice and try the next choice
      temp_list.remove(temp_list.size() - 1);
    }
    return output;
  }
}

// edge cases: empty array
// constraints: limit is 10, so recurssive exhaustive solution

// given [1,2,3] -> 1->1, 1->2, 1->3, 2->2, 2->3, 3->3, 1->2->3
// iterative for loop based solution with pivot?
// add empty array to the solution

// for loop based iteration
// normal recurssion

//tc: O(n*2^n)
//sc: O(n);

class Solution {

  List<List<Integer>> result;

  public List<List<Integer>> subsets(int[] nums) {
    this.result = new ArrayList<>();
    helper(nums, 0, new ArrayList<>());
    return result;
  }

  private void helper(int[] nums, int pivot, List<Integer> path) {
    //base
    result.add(new ArrayList<>(path));

    //logic
    for (int i = pivot; i < nums.length; i++) {
      path.add(nums[i]);
      helper(nums, i + 1, path);
      path.remove(path.size() - 1);
    }
  }
}

// normal recurssion

class Solution {

  List<List<Integer>> result;

  public List<List<Integer>> subsets(int[] nums) {
    this.result = new ArrayList<>();
    helper(nums, 0, new ArrayList<>());
    return result;
  }

  private void helper(int[] nums, int pivot, List<Integer> path) {
    //base
    if (pivot == nums.length) {
      result.add(new ArrayList<>(path));
      return;
    }

    //logic -> choose and not choose
    helper(nums, pivot + 1, path);
    path.add(nums[pivot]);

    helper(nums, pivot + 1, new ArrayList<>(path));
    path.remove(path.size() - 1);
  }
}

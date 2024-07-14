// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Recursion - 0-1
/*class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>());
        return result;
    }

    void recurse(int[] nums, int index, List<Integer> path) {
        // Base
        if(index == nums.length) {
            result.add(path);
            return;
        }
        // Logic
        // 0 or do not choose:
        recurse(nums, index+1, new ArrayList<>(path));
        // 1 or choose case:
        path.add(nums[index]);
        recurse(nums, index+1, new ArrayList<>(path));
    }
}*/

// Backtracking - 0-1
/*class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    void backtrack(int[] nums, int index, List<Integer> path) {
        // Base
        if(index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Logic
        // 0 or do not choose:
        backtrack(nums, index+1, path);
        // 1 or choose case:
        path.add(nums[index]);
        backtrack(nums, index+1, path);
        path.remove(path.size()-1);
    }
}*/

// Recursion - for loop
class Solution {
  List<List<Integer>> result;
  public List<List<Integer>> subsets(int[] nums) {
    result = new ArrayList<>();
    recursion(nums, 0, new ArrayList<>());
    return result;
  }

  void recursion(int[] nums, int index, List<Integer> path) {
    // Base
    result.add(path);
    // Logic

    for(int i = index; i<nums.length; i++) {
      List<Integer> newList = new ArrayList<>(path);
      newList.add(nums[i]);
      // Recurse:
      recursion(nums, i+1, newList);
    }
  }
}

// Backtracking - for loop
/*class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    void backtrack(int[] nums, int index, List<Integer> path) {
        // Base
        result.add(new ArrayList<>(path));
        // Logic

        for(int i = index; i<nums.length; i++) {
            // Action:
            path.add(nums[i]);
            // Recurse:
            backtrack(nums, i+1, new ArrayList<>(path));
            // Backtrack:
            path.remove(path.size()-1);
        }
    }
}*/
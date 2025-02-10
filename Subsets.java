// In this problem, we using backtracking, we are carrying a data structure with us i.e list, adding the subsets to the list, and 
// making further recursive calls.

// Time Complexity :Exponential
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// 0-1 recursion solution:
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        // Declare result list
        result = new ArrayList<>();
        // Recursive call
        recurse(nums, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        // If we are out of values, add the subset to the outer list and return
        if (index == nums.length) {
            result.add(path);
            return;
        }
        // Logic
        // 0 case or do not pick case
        recurse(nums, index + 1, new ArrayList<>(path));
        // 1 case or pick case
        path.add(nums[index]);
        recurse(nums, index + 1, new ArrayList<>(path));
    }
}

// Backtracking using 0-1 recursion
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Logic
        // 0 case or do not pick case
        backtrack(nums, index + 1, path);
        // 1 case or pick case
        // Action
        path.add(nums[index]);
        // Recurse
        backtrack(nums, index + 1, path);
        // Backtrack
        path.remove(path.size() - 1);
    }
}

// For loop based recursion solution
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        // Logic
        result.add(path);
        for (int i = index; i < nums.length; i++) {
            List<Integer> newList = new ArrayList<>(path);
            newList.add(nums[i]);
            recurse(nums, i + 1, newList);
        }
    }
}

// Backtrack using for loop based recursion:
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> path) {
        // Logic
        result.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
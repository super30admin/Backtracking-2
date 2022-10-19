// Approach - 1
// TC and SC : O(N * 2 ^ N)
// Executed
// Recursive approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        helper (nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper (int[] nums, int index, List<Integer> path) {
        // base
        if (index == nums.length) {
            result.add(path);
            return;
        }
        // logic
        // donot choose or 0 case
        helper(nums, index + 1, new ArrayList<>(path));
        // choose or 1 case
        path.add(nums[index]);
        helper(nums, index + 1, new ArrayList<>(path));
    }
}

// Approach - 2
// Recursion with backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        helper (nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper (int[] nums, int index, List<Integer> path) {
        // base
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        // donot choose or 0 case
        helper(nums, index + 1, path);
        // choose or 1 case
        // action
        path.add(nums[index]);
        // recursion
        helper(nums, index + 1, path);
        // backtracking
        path.remove(path.size() - 1);
    }
}

// Appraoch - 3
// for-loop based recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        helper (nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper (int[] nums, int index, List<Integer> path) {
        result.add(path);
        for (int i = index; i < nums.length; i++) {
            List<Integer> newList = new ArrayList<>(path);
            newList.add(nums[i]);
            helper(nums, i + 1, newList);
        }
    }
}

// Approach - 4
// for-loop based recursion with backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        helper (nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper (int[] nums, int index, List<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            // action
            path.add(nums[i]);
            // recursion
            helper(nums, i + 1, path);
            // backtracking
            path.remove(path.size() - 1);
        }
    }
}
/**
Problem: https://leetcode.com/problems/subsets/
TC: O(2^n)
SC: O(n) for the recursive stack space
*/

/**
Approach 1: backtracking - choose or not choose
*/
class Solution {
    List<List<Integer>> result = null;
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void helper(int nums[], List<Integer> subset, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        
        // Case 1: choose not to add
        helper(nums, subset, index + 1);
        // Case 2: choose to add
        subset.add(nums[index]);
        helper(nums, subset, index + 1);
        subset.remove(subset.size() - 1);
    }
}

/**
Approach 2: Backtracking with for loop
*/
class Solution {
    List<List<Integer>> result = null;
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void helper(int nums[], List<Integer> subset, int index) {
        // Only basecase would be to check for index out of bounds but that doesn't happen because of the for loop
        result.add(new ArrayList<>(subset));
        
        for (int i = index; i < nums.length; ++i) {
            subset.add(nums[i]);
            helper(nums, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}

/**
Approach 3: Using iteration
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        
        for (int num : nums) {
            int size = subsets.size();
            for (int i = 0; i < size; ++i) {
                List<Integer> curSubset = new ArrayList<>(subsets.get(i));
                curSubset.add(num);
                subsets.add(curSubset);
            }
        }
        
        return subsets;
    }
}
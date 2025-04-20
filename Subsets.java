import java.util.*;

//Time Complexity: O(2^n) where n is the length of the input array, as we explore all possible subsets.
//Space Complexity: O(n) for the recursion stack and the result list, where n is the length of the input array.
//LeetCode: https://leetcode.com/problems/subsets/

/**
 * Generates all possible subsets (the power set) of a given integer array.
 * Uses backtracking to explore each inclusion/exclusion choice per element.
 * Returns a list of all unique subsets.
 */

public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<List<Integer>>();
        helper(nums, new ArrayList<Integer>(), 0);
        return result;
    }

    public void helper(int[] nums, List<Integer> subset, int pivot) {
        result.add(new ArrayList<>(subset));
        if(subset.size() == nums.length) return;

        for(int i = pivot; i < nums.length ; i++) {
            subset.add(nums[i]);
            helper(nums, subset, i+1); 
            subset.remove(subset.size()-1);
        }
    }
}
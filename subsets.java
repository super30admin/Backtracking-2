import java.util.*;

class Solution {
    // Main function to get all subsets of the given array
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // List to store all subsets
        helper(0, nums, new ArrayList<>(), result); // Start the recursive helper function
        return result; // Return the list of subsets
    }

    // Recursive function to generate subsets
    private void helper(int pivot, int[] nums, List<Integer> list, List<List<Integer>> result) {
        // Add the current subset (list) to the result
        result.add(new ArrayList<>(list));

        // Iterate through the array starting from the pivot index
        for (int i = pivot; i < nums.length; i++) {
            // Add the current number to the subset
            list.add(nums[i]);

            // Recursively generate subsets starting from the next index
            helper(i + 1, nums, list, result);

            // Remove the last number added to the subset (backtrack)
            list.remove(list.size() - 1);
        }
    }
}

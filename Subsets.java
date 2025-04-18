// Time complexity:- O(2^n), where n is the length of the input array.
// Space complexity:- O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach:
 * This problem is about generating all possible subsets (the power set) of a given integer array.
 * I used a backtracking approach where at each step, I loop from the current pivot index,
 * include the current element, recurse forward, and then backtrack to explore other combinations.
 */
class Solution {
    // List to store all the subsets
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {

        result = new ArrayList<>(); 

        helper(nums, 0, new ArrayList<>()); 

        return result; 
    }

    //Backtracking helper function to generate subsets.
    private void helper(int[] nums, int pivot, List<Integer> path) {

        // Add the current subset to the result
        result.add(new ArrayList<>(path));

        // Iterate over choices starting from the pivot index
        for (int i = pivot; i < nums.length; i++) {
            // Choose the element
            path.add(nums[i]); 

            // Recurse with the next index
            helper(nums, i + 1, path); 

            // Backtrack: undo the choice
            path.remove(path.size() - 1); 
        }
    }
}

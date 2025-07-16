// Time Complexity: O(2^n) where n is the number of elements in nums
// Space Complexity: O(n) for recursion stack and current path

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// This backtracking solution explores all subsets of the given array.
// At each index, we decide whether to include the current number (choose) or not (no choose).
// The recursion continues until we reach the end of the array (base case), where we add the current path to the result.
// We use backtracking to undo choices after each recursive call and explore other paths.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums,0,new ArrayList<Integer>());
        return result;

    }

    private void helper(int[] nums, int i, List<Integer> path) {
        //bc leaf node
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        //no choose
        helper(nums,i+1,path);

        //choose
        path.add(nums[i]);
        helper(nums,i+1,path);
        //backtrack
        path.removeLast();
    }
}
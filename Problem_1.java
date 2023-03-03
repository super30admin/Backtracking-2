// Time Complexity : O(N * 2^N) where N is size of input
// Space Complexity : O(N), size of list
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use backtracking here. We initialize our pivot to 0 and start calling helper function recursively for all values of i.
   We keep on adding the path so far to our result. Once i goes out of bounds, we backtack and remove added element from list.
   In this way using backtracking we can re-use a single list to decrease our space complexity. In the end we return the result.
*/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        
        helper(nums, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path) {
        
        result.add(new ArrayList<>(path));

        for(int i = pivot; i < nums.length; ++i) {
            path.add(nums[i]);
            helper(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
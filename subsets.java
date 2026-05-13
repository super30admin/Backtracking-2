// Time Complexity : O(n * 2^n) because there are 2^n possible subsets and copying each subset can take O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use backtracking to generate all possible subsets by starting from a pivot index and exploring every available choice one by one.
// At every recursive call, we add a deep copy of the current path into the result because every intermediate path itself represents a valid subset.
// Backtracking removes the last added element after recursion so that other subset combinations can be explored correctly.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for(int i = pivot; i < nums.length; i++) {
            //action
            path.add(nums[i]);
            
            // recurse
            helper(nums, i+1, path, result);

            // backtrack
            path.remove(path.size()-1);
        }
    }
}
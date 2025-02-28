// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class SubstesBacktrackingWithForLoopRecursion {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums, 0, path);
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path) {
        result.add(new ArrayList<>(path));

        // logic
        for (int i = pivot; i < nums.length; i++) {
            // action
            path.add(nums[i]);
            // recurse
            helper(nums, i + 1, path);
            // backtrack
            path.remove(path.size() - 1);
        }
    }
}

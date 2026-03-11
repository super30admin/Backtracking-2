// Time Complexity : O(n * 2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to use a for loop based recursion approach where we follow the steps of action, recurse
and backtrack.Our task/action is to add each element to the path and recurse it further without choosing
the same element(pivot) as question said no duplicates.We backtrack at every recursion to find the
possible combinations and not include unrequired/duplicate combination in the result set.
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path) {
        result.add(new ArrayList<>(path));
        for(int i = pivot ; i < nums.length ; i++) {
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i + 1, path);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}
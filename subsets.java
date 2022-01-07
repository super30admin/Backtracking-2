// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// This method/technique is known as "Itterative Recursive Template"
// We are using a single path list and backtracking and removing the last element after the recurse step
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return result;
        dfs(nums, 0, new ArrayList<>());

        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> path) {
        //base

        //logic
        result.add(new ArrayList<>(path));
        for (int i=index; i<nums.length; i++) {
            //action
            path.add(nums[i]);
            //recurse
            dfs(nums, i+1, path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}
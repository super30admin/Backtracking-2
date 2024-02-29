// https://leetcode.com/problems/subsets/

// Time Complexity: O(2^n)
// Space Complexity: O(2^n + n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path) {
        //base
        // if(pivot == nums.length) {
        result.add(new ArrayList<>(path));
        // return;
        // }

        //logic
        //not choose
        // helper(nums, idx+1, path);

        //choose
        // path.add(nums[idx]);
        // helper(nums, idx+1, path);

        //backtrack
        // path.remove(path.size() - 1);

        for(int i = pivot; i < nums.length; i++) {
            //choose
            path.add(nums[i]);
            helper(nums, i+1, path);

            //backtrack
            path.remove(path.size() - 1);
        }
    }
}
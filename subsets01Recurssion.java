// Time Complexity : O(2^n)
// Space Complexity : O(2^n*n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums,0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int i, List<Integer> path){
        //base
        if(i == nums.length){
            result.add(path);
            return;
        }

        //logic
        //not choose
        helper(nums, i+1, new ArrayList<>(path));

        //choose
        //action
        path.add(nums[i]);
        //recurse
        helper(nums,i+1, new ArrayList<>(path));
    }
}
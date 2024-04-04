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

    private void helper(int[] nums, int pivot, List<Integer> path){
        result.add(path);
        for(int i = pivot; i < nums.length; i++){
            List<Integer> li = new ArrayList<>(path);
            li.add(nums[i]);
            helper(nums, i+1, li);
        }
    }
}
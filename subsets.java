
// Time Complexity : O(2^N)
// Space Complexity : O(2^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA

class Solution {
    List<List<Integer>> res;    
    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int pivot,List<Integer> path) {

        res.add(new ArrayList<>(path));

        for(int i=pivot;i<nums.length;i++) {
            // action
            path.add(nums[i]);
            // recurse
            helper(nums,i+1,path);
            // backtrack    
            path.remove(path.size()-1);
        }
    }
}

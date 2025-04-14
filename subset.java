// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>());
        return res; 
    }
    private void recurse(int[] nums, int index, List<Integer> path){
        res.add(new ArrayList<>(path));

        for(int i = index; i< nums.length; i++){
            //action
            path.add(nums[i]);
            //recurse
            recurse(nums, i + 1, path);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}
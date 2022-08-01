// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    void helper(int[] nums,int index,List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}
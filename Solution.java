// Time Complexity : o(2^n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        if(nums == null || nums.length ==0) return res;
        helper(nums, path , 0);
        return res;
    }
    private void helper(int[] nums, List<Integer> path, int index)
    {

        res.add(new ArrayList(path));
        
        //logic
        for(int i =index ; i<nums.length; i++)
        {
            path.add(nums[i]);
            helper(nums, path, i+1);
            path.remove(path.size()-1);
        }
    }
}
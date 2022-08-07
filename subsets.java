// Time Complexity : exponential
// Space Complexity : exponential
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution
{
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0)
        {
            return result;
        }
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index,List<Integer> path)
    {
        result.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++)
        {
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}
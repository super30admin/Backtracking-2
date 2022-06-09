//https://leetcode.com/problems/subsets/
// Time Complexity :O(exponential) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no



class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        helper(nums,0,new ArrayList<Integer>());
        return result;
    }
    private void helper(int[] nums,int idx,List<Integer> path)
    {
        result.add(new ArrayList<>(path));//adds empty array first, while second element recursion is called first element is added to the main list since it is there in the path
        for(int i=idx;i<nums.length;i++)
        {
            path.add(nums[i]); //adds first element recurses from second element
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}
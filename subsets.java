// Runtime complexity - O(2^N) - Exponential operation
// Space complexity - O(N) where N is the maximum depth of the recursion stack.

class Solution {  
    List<List<Integer>> output;
    public List<List<Integer>> subsets(int[] nums) {
    output = new ArrayList();
    if(nums==null || nums.length==0)
       return output;
    //helper(nums,0,new ArrayList<Integer>());
    helper_iterative(nums,0,new ArrayList<Integer>());
    return output;
  }
    
    public void helper_iterative(int[] nums, int index, List<Integer> path)
    {
        output.add(new ArrayList<Integer>(path));
        for(int i=0;i<nums.length;i++)
        {
            //dont choose
            //helper(nums,i+1,path);
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
        return;
        
    }
    
    private void helper(int[] nums,int index, List<Integer> path)
    {
        if(index==nums.length)
        {
            output.add(new ArrayList<Integer>(path));
            return;
        }
        
        //choose
        path.add(nums[index]);
        helper(nums,index+1,path);
        path.remove(path.size()-1);
        helper(nums,index+1,path);
        //backtract
        //dont choose
        return;
    }
}

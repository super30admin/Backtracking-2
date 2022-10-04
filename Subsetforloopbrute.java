class Solution {
     //tc - 2n
    //sc- 2n
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums,int pivot,List<Integer> path) 
    {
        //base case
        result.add(path);
        
        //logic
        for(int i=pivot;i<nums.length;i++)
        {
            List<Integer> temp = new ArrayList<>(path);
            temp.add(nums[i]);
            helper(nums,i+1,temp);
        }
        
        
    }
}
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
        result.add(new ArrayList<>(path));
        
        //logic
        for(int i=pivot;i<nums.length;i++)
        {
            //action
            path.add(nums[i]);
            //recurse
            helper(nums,i+1,path);
            //backtrack
            path.remove(path.size()-1);
        }
        
        
    }
}
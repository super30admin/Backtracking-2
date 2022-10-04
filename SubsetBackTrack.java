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
    private void helper(int[] nums,int idx,List<Integer> path) 
    {
        //base case
        
        if(idx == nums.length)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //not choose
        helper(nums,idx+1,path);
        //choose
        //action
        path.add(nums[idx]);
        //recurse
        helper(nums,idx+1,path);
        //backtrack
        path.remove(path.size()-1);
        
        
    }

}
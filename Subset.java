class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList();
        dfs(nums, 0, new ArrayList());
        list.add(new ArrayList());
        return new ArrayList(list);
    }
    
    private void dfs(int[] nums, int index, List<Integer> currSet) {
        
        if(index >= nums.length) {
            
            return;
        }
        
        list.add(currSet);
        

        dfs(nums,index+1, new ArrayList(currSet));
        
        

        currSet.add(nums[index]);
        dfs(nums, index+1, new ArrayList(currSet));
        
        
        
    }
}

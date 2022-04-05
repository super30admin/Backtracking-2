class SubSet {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums,0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path){
        //base
        if(index == nums.length){
            result.add(path);
            return;
        }
        
        //logic
        
        //not choose
        helper(nums, index+1, path);
        
        //choose
        List<Integer> pathTmp = new ArrayList<>(path);
        pathTmp.add(nums[index]);
        helper(nums,index+1,pathTmp);
    }
}

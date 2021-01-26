class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        
        if(nums.length == 0 || nums == null)
        return result;
        
        helper(nums,new ArrayList<>(),0);
        return result;
    }
    private void helper(int[] nums,ArrayList<Integer> path,int index){
        
        //base
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        
        helper(nums,path,index+1);
        path.add(nums[index]);
        helper(nums,path,index+1);
        path.remove(path.size() - 1);
    }
}

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return res;
    }
    private void helper(int [] nums, int i, List<Integer> path){
        res.add(new ArrayList<>(path));
        
        if(i>=nums.length){
            return;
        }
          
        for(;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }

}

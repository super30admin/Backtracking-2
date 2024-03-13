class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;


        
    }
    private void helper(int[] nums, int pivot, List<Integer> path){
       
            res.add(new ArrayList<>(path));
       
        
       
      
       for(int i=pivot;i<nums.length;i++){
         //choose
        path.add(nums[i]);
        helper(nums, i+1, (path));

        path.remove(path.size()-1);
       }
        
    }
}

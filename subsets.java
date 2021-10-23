class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        if(nums == null || nums.length == 0) return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int [] nums, int i,List<Integer> path){
        //basic
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        //dont choose the nums
        helper(nums, i + 1, path);
        
        //choose
        path.add(nums[i]);
        helper(nums, i + 1, new ArrayList<>(path));
        
        
        //backtracking
        path.remove(path.size()-1);
    }   
}
// TC : o(n * 2n)

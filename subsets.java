class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helper(nums, new ArrayList<Integer>(), 0);
        return result;
        
    }

    private void helper(int[] nums, List<Integer> path, int index ){
        
        result.add(new ArrayList(path));
        for(int i = index; i < nums.length; i++){
            // action 
            path.add(nums[i]);
            
            // recurse
            helper(nums, path, i + 1);
            
            // backtrack
            path.remove(path.size() - 1);
            
        }
    }
}

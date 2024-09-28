class Solution {
    
    List<List<Integer>> output;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        output = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>());
        
        return output;
        
    }
    
    private void backtrack(int[] nums, int start, List<Integer> currentPath){
        output.add(new ArrayList<>(currentPath));
        
        for (int x = start; x < nums.length; x++){
            currentPath.add(nums[x]);
            backtrack(nums,x+1,currentPath);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
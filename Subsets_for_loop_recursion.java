// TC : 2^n
// SC : O(n)
// Method - 2 : for loop based recursion 

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        helper(nums, 0, new ArrayList<>());
        
        return result;
        
        
    }
    
    private void helper(int[] nums, int index, List<Integer> path) {
        
        result.add(new ArrayList<>(path));
        for(int i = index; i < nums.length; i++) {
 
            path.add(nums[i]);
            helper(nums, i+1, path);
            
            path.remove(path.size() - 1);
        }
        
    }
}

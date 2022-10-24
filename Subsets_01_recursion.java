// TC : 2^n
// SC : O(n)
// Method - 1 : 0,1 based recursion 

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        helper(nums, 0, new ArrayList<>());
        
        return result;
        
        
    }
    
    private void helper(int[] nums, int index, List<Integer> path) {
        
        if(nums.length == index) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        helper(nums, index+1, path);
        path.add(nums[index]);
        
        helper(nums, index+1, path);
        path.remove(path.size() - 1);
        
    }
}

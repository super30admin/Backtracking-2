//subsets
// Time Complexity : O(n*2^n)
// Space Complexity : O(n)

class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path){
        
        result.add(new ArrayList<>(path));
        
        if(index==nums.length){
            return;
        }
        
        for(int i = index; i<nums.length; i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
        
    }
}

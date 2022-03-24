/*
    Time complexity : O(2^n)
    Space complexity : O(n)
*/
class Solution {
    
    private List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int vidx, ArrayList<Integer> subsets){
        if(vidx==nums.length){
            result.add(new ArrayList<>(subsets));
            return;
        }
        
        subsets.add(nums[vidx]);
        helper(nums, vidx + 1, subsets);
        subsets.remove(subsets.size() - 1);
        
        helper(nums, vidx + 1, subsets);
    }
    
    
}

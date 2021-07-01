class Solution {
    // Time complexity: O(N * 2^N)
    // Space complexity: O(N)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        helper(nums, 0, new ArrayList<>(), results);
        
        return results;
    }
    
    public void helper(int[] nums, int idx, List<Integer> result, List<List<Integer>> results){
        if(idx == nums.length){
            results.add(new ArrayList<>(result));
            return;
        }
        result.add(nums[idx]);
        helper(nums, idx + 1, result, results);
        result.remove(result.size() - 1);
        
        helper(nums, idx + 1, result, results);
        
    }
}
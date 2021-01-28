// Link: https://leetcode.com/problems/subsets/

// Time Complexity: O(2 ^ N  * N)
// Space Complexity: O(2 ^ N  * N)

class Solution {
    List<List<Integer>> result;
    
    public void helper(int[] nums, int index, List<Integer> output) {
        result.add(new ArrayList<Integer>(output));
        
        if (index == nums.length) {
            
            return;
        }
        
        for (int i= index; i < nums.length; i++) {
            output.add(nums[i]);
            helper(nums, i + 1, output);
            output.remove(output.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        
        helper(nums, 0, new ArrayList<Integer>());
        
        return result;
    }
}
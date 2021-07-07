// Time Complexity - Exponential(2^n)
// Space Complexity - O(1)
// This solution worked on LeetCode


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) { 
    // Edge Case
        if(nums == null || nums.length == 0)
            return result;
            // Call helper function for index 0
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> temp){
        // Base Case
        if(index > nums.length) return;
        //Logic
        // Add new Arraylist to the result
        result.add(new ArrayList<>(temp));
        for(int i=index; i< nums.length; i++){
            temp.add(nums[i]);
            helper(nums, i + 1, temp);
            //backtrack by removing the last element in the list
            temp.remove(temp.size() -1);
        }
    }
}

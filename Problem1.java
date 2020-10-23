// Time Complexity : O(N * 2^N)
// Space Complexity : O(N * 2^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Using Backtracking approach

class Solution {
    ArrayList<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return output;
        ArrayList<Integer> arr = new ArrayList<>();
        helper(nums, arr, 0);
        return output;
    }
    
    private void helper(int[] nums, ArrayList arr, int index){
        
        output.add(new ArrayList<>(arr));
        
        for(int i = index; i < nums.length; i++){
             arr.add(nums[i]);
             helper(nums, arr, i+1);
             arr.remove(arr.size()-1);
        }
    }
}

// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(2 power n) since we have 2 choices (choose/not choose) being iterated exponentially
//Space Complexity: O(H) where H is the height of the choices tree 
 class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helper(nums, new ArrayList<>(), 0);
        return result;        
    }
    
    private void helper(int[] nums, List<Integer> path, int i){
        //base case
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //action
        path.add(nums[i]);
        
        //recurse
        helper(nums, path, i+1);
        
        //backtrack
        path.remove(path.size() - 1);
               
        helper(nums, path, i+1);
    }
}
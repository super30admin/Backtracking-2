// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Backtracking
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0)
            return res;     
        
        backtracking(nums, 0, new ArrayList<>());
        return res;   
    }
    
    private void backtracking(int[] nums, int index, List<Integer> path){
        // base case
        if(index>=nums.length){
           res.add(new ArrayList<>(path));
           return;
        }   
        // recurse case
        res.add(new ArrayList<>(path));
        for(int i=index; i<nums.length; i++){
            path.add(nums[i]);
            backtracking(nums, i+1, path);
            path.remove(path.size()-1);
        }
    } 
}
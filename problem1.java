package Backtracking-2;

public class problem1 {
    // Time Complexity : O(2^n), n is no. of elements in an array
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        
        if(nums == null || nums.length == 0) return res;
        
        helper(nums, 0, new ArrayList<>());
        
        return res;
    }
    
    public void helper(int[] nums, int index, List<Integer> path){
        //base
        if(nums.length == index)  {
            res.add(path);
            return;
         }
        
        
        //logic
        //skip
        helper(nums,index+1, new ArrayList<>(path));
        //take
        path.add(nums[index]);
        helper(nums, index+1, new ArrayList<>(path));
        path.remove(path.size()-1);
    }
}

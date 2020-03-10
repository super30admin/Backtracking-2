// Time Complexity :O(2^n) --> There are 2 decisions at each index to make.
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length ==0)
            return result;
        
        backtracking(nums, new ArrayList<>(), 0);
        
        // recursion_mtd(nums, new ArrayList<>(), 0);
        return result;
    }
    
//********* Approach 1*********
    // Backtracing 
    private void backtracking(int[] nums, List<Integer> currPath, int index){
        
        // base
        if(nums.length == index){
            result.add(new ArrayList<>(currPath));
            return;
        }
    
        //logic
        result.add(currPath);  // Aways add the value to current path as every new path we take here is a new subset. Because of this step we can igore base case!!!
        //Action
        for(int i=index;i<nums.length;i++){
         currPath.add(nums[i]);
        //recurse
        backtracking(nums, new ArrayList<>(currPath), i+1);
        //backtrack
        currPath.remove(currPath.size()-1);
           
        }
         
    }
//********* Approach 2*********
    //Recussion method
    private void recursion_mtd(int[] nums, List<Integer> currPath, int index){
        // base
        if(index == nums.length){
            result.add(currPath);
            return;
        }
            
        //logic
        /// Not Choose
        recursion_mtd(nums, new ArrayList<>(currPath), index+1);
        
        // Choose
        currPath.add(nums[index]);
        recursion_mtd(nums, new ArrayList<>(currPath), index+1);
    }
    
    
}

/**
 * 
 * Time Complexity :
 * Space Complexity :
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * 
 *
 
 */
class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        
        if(nums == null || nums.length == 0) return result;
        
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(int [] nums, List<Integer> temp, int index){
        
        //base
       if(index < nums.length + 1){
           
           result.add(new ArrayList<>(temp));
           
       }
       
        //logic
        
        for(int i = index; i < nums.length; i++){
            
            //action
            temp.add(nums[i]);
            
            //recurse
            backtrack(nums, temp, i+1);
            
            //backtrack
            temp.remove(temp.size() - 1);
        }
        
    }
}
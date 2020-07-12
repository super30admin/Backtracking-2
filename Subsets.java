// Time Complexity : O(n*2^n)
// Space Complexity : O(n*2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Solution : Recursion 
class Solution {
    //declare result globally
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        //initialize result
        result = new ArrayList<>();
        //check for null and empty array condition
        //if null/length = 0, return empty result 
        if(nums == null || nums.length == 0) return result;   
        //call helper method
        //with parameters nums array, new list for temp and index position = 0
        helper(nums, new ArrayList<>(), 0);
        //return the result list
        return result;
               
    }
    
    private void helper (int[] nums, List<Integer> temp, int index) {
        //base condition
        //if index out of bounds, add the temp list to result and return
        if(index == nums.length) {
            //just add temp and not new list temp as at each recursive call 
            // we send a new temp list
            result.add(temp);
            return;
        }
             
        //logic
        //dont choose number :
        //so we dont add the number to temp and send temp as it is
        //increase index by 1
        helper(nums, new ArrayList<>(temp), index+1);
        
        //choose :
        //we add the number to temp and send a copy of temp 
        //increase index by 1 (no reps allowed)
        temp.add(nums[index]);
        helper(nums, new ArrayList<>(temp), index+1);
        
    }

}

///////////////

// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Solution : Backtracking 
class Solution {
    //declare result globally
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        //initialize result
        result = new ArrayList<>();
        
        //dont check for null and empty array condition
        //backtracking will take care, for empty list result should be [[]] 
        
        //call helper method
        //with parameters nums array, new list for temp and index position = 0
        backtrackinghelper(nums, new ArrayList<>(), 0);
        //return the result list
        return result;               
    }
    
    private void backtrackinghelper(int[] nums, List<Integer> temp, int index) {
        //NO base case, length index out of bound is taken care in for loop
        
        //add the current temp list before running for loop to result list
        //add a copy of temp list (less space than recursion)
        //(in recursion we have new temp list at each call,)
        //(in backtracking only when we copy it to result)
        //(we miss out empty subset)
        //if we add temp in for loop before calling backtrack method again
        result.add(new ArrayList<>(temp));    
        
        //LOGIC MAIN
        //run loop from index and not 0
        //to nums.length
        for(int i = index; i < nums.length; i++) {
            //LOGIC
            //add the current ith element to temp
            temp.add(nums[i]);
            
            //RECURSIVE CALL
            //call method on this temp and increase i (index) by 1 
            //(for loop in next call will begin from this number)
            backtrackinghelper(nums, temp, i+1);
            
            //BACKTRACKING
            //backtrack : remove last added element from temp 
            //and start for loop for next index
            temp.remove(temp.size()-1);
        }        
    }
}

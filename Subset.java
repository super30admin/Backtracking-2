/* Time Complexity : 
Recursive: O(n * 2^n) where n is the number of elements. n copies of temporary list to result at each recursion
Backtracking: O(n * 2^n) where n is the number of elements, n copies of temporary list to result at each recursion
Space Complexity : 
Recursive: O(n * 2^n) where n is the number of elements. n copies of temporary list at each recursion
Backtracking: O(n), maintaining a single temp list througout for storing the subsets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach:  We have two decisions: choosing an element for subset or not choosing the same.
Regardless on if we are choosing the element or not choosing, we move to the next index to choose the next one. As we are reaching the end of the
list, we are adding the copies of temp list (whatever subset we got till here) to the result.*/

// RECURSION
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){return result;}
        List<Integer> temp = new ArrayList<Integer>();
        helper(nums, 0, temp);                                                      // Start the recursion
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> temp){
        if(index == nums.length){                                                       // index has reached the end of the list
            result.add(temp);                                                           // Add whatever subset got here till now to the result
            return;
        }
        // No choose
        helper(nums, index+1, new ArrayList<Integer>(temp));                                    
        //Choose
        temp.add(nums[index]);                                                      // if chosen, add to your temp list
        helper(nums, index+1, new ArrayList<Integer>(temp));
        
    }
}

// BACKTRACKING
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){return result;}
        List<Integer> temp = new ArrayList<Integer>();
        backtrack(nums, 0, temp);                                                               // Start the Recursion
        return result;
    }
    private void backtrack(int[] nums, int index, List<Integer> temp){
        result.add(new ArrayList<>(temp));                                                     // Add the temp list on the subsets got here till now
        for(int i  = index; i < nums.length;i++){      
        //Choose
        temp.add(nums[i]);                                                                      // Add elements to temp list
        backtrack(nums, i+1, temp);
        temp.remove(temp.size()-1);                                                             // Backtrack by removing the last element
        }  
    }
}
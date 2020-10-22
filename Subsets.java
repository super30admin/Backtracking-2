// Time Complexity : O(n*2^n), O(n) to copy final result to output array, 2^n is the number of possibilities we can generate in the recursion tree given n numbers
// Space Complexity : O(n) is the max recursion depth, O(n*2^n) if we consider output space as well

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : visualizing the recursion, could not come up with how combinations are generated in the recursive way 
// now after iterating through the code, it is clear

// Your code here along with comments explaining your approach
// we try to generate combinations by picking 1 element and calling the recursive function to generate all combinations where 1 is present
// the subtree of 1 will have all combinations where 1 is present
// after the call is done, we remove 1 and add 2, call recursive function
// we avoid previously chosen numbers to avoid duplicates 

class Solution {
    List<List<Integer>> output;
    
    public List<List<Integer>> subsets(int[] nums) {
        output = new ArrayList<List<Integer>>();
        
        List<Integer> combination = new ArrayList<Integer>();
        int idx = 0;
        
        helper(nums, idx, combination);
        
        return output;
    }
    
    private void helper(int[] nums, int index, List<Integer> combination){
        //base case
        if(index>nums.length){
            return;
        }
        
        output.add(new ArrayList(combination));
        
        for(int i=index; i<nums.length; i++){
            combination.add(nums[i]);
            helper(nums, i+1, combination);
            combination.remove(combination.size()-1);
        }
    }
}
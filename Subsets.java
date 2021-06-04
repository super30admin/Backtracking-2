// Time Complexity : O(2^n)
// Space Complexity : O(n) The max height of the stack will be when path length = nums length
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Fumbled a little when passing index value of the helper function in for loop.


// Your code here along with comments explaining your approach

public class Subsets {
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        // base condition check for inputs
        if(nums == null || nums.length == 0) return result;
        
        helper(result, nums, new ArrayList<>(), 0);
        
        return result;
    }
    
    public void helper(List<List<Integer>> result, int[] nums, List<Integer> path, int index){
        
        // base case
        // Since we need to generate all combinations of the given list we don't have a set condition to add the path to the result list.
        // The index bounds are taken care by the for loop. so no index overflow will happen.
        
        // main logic
        // Adding every generated path to result.
        result.add(new ArrayList<>(path)); 
        for(int i = index; i < nums.length; i++){
            path.add(nums[i]); // action
            helper(result, nums, path, i+1); // backtrack
            path.remove(path.size()-1); // recurse
        }
    }

}

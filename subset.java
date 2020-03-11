// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//we just need to add the elements in set one by one. So the idea is to manipulate
//the cursor (or index). 

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solution = new LinkedList<>();
        List<Integer> state = new LinkedList<>();
        
        backtrack(solution, state, nums, 0);
        
        return solution;
    }
    
    
    private void backtrack(List<List<Integer>> solution, List<Integer> state, int[] nums, int index){
        
        //terminating condition
        if(state.size() <= nums.length){
            solution.add(new LinkedList<>(state));
            //return;
        }
        
        //try candidates
        for(int i=index; i<nums.length; i++){            
            state.add(nums[i]);
            
            backtrack(solution, state, nums, i + 1);
            state.remove(state.size() -1);
        }
    }
}
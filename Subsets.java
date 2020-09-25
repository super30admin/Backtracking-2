// Time Complexity : O(n * Math.pow(2,n)) because we are checking for each possibility for subsets 
//and copying the references of the elements of the generated subset into the main output arraylist
// Space Complexity : O(n * Math.pow(2,n)) number of solutions of subsets multiplied by the total number of possibilities or choices we have to make
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
 
class Solution {
    
    private List<List<Integer>> output = new ArrayList();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        if(nums == null || nums.length == 0)    return new ArrayList();
        
        List<Integer> path = new ArrayList();
        backtrack(nums, 0, path);
        
        return output;
        
    }
    
    private void backtrack(int[] nums, int index, List<Integer> path){
        
        output.add(new ArrayList(path));
        
        for(int i = index; i < nums.length; i++){
            
            //add the element to the path
            path.add(nums[i]);
            
            //backtracking to find the all possible subsets
            backtrack(nums, i+1, path);
            
            //remove the element from the path
            path.remove(path.size() - 1);
        }
        
    }
    
}

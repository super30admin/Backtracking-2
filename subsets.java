// Time Complexity : O(n*2^n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    
    List<List<Integer>> subsets;
    public List<List<Integer>> subsets(int[] nums) {
        
        subsets= new ArrayList();
        backtrack(nums, new ArrayList(), 0);
        return subsets;
         
    }
    
    public void backtrack(int[] nums, List<Integer> temp, int start) {
        
        // Base case
        subsets.add(new ArrayList(temp));

        // For all cases
        for(int i=start;i<nums.length;i++) {
            
            temp.add(nums[i]);
            backtrack(nums, temp, i+1);
            temp.remove(temp.size()-1);
        }
        
        // remove last index
        
    }
    
}

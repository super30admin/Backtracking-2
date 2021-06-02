// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    For each node we have 2 options to either add that element or skip the element 
*/

class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        path = new ArrayList<>();
        
        backtrack(nums, 0);
        
        return result;
    }
    
    public void backtrack(int[] nums, int index){
        
        if (index == nums.length) {
            result.add(new ArrayList(path));
            return;
        }
        
        backtrack(nums, index+1);
        
        path.add(nums[index]);
        backtrack(nums, index+1);
        path.remove(path.size()-1);
    }
}
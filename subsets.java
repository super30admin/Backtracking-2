// Time Complexity : O(2^N) 
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Add a for loop and add the elements into the arraylist.
2. Then backtrack and remove the elements from the arraylist

*/


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> solution;
    public List<List<Integer>> subsets(int[] nums) {
        solution = new ArrayList<>();
        
        backtrack(nums, 0, new ArrayList<Integer>());
        
        return solution;
    }
    
    public void backtrack(int[] nums, int index, List<Integer> path) {
        solution.add(new ArrayList<>(path));
        
        for(int i=index;i<nums.length;i++) {
            path.add(nums[i]);
            backtrack(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}

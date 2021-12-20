// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        helper(nums,0,new ArrayList<>());
        
        return result;
    }
    private void helper(int[] nums,int index,List<Integer> path) {
        
        // base
        //if(!result.contains(path)) {
            result.add(new ArrayList(path));
        //}
        
        
        if(index == nums.length) {
            return;
        }
        
        //backtracking 
        for(int i=index;i<nums.length;i++) {
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    
        //recursion
        // helper(nums, index+1, new ArrayList(path));
        // path.add(nums[index]);
        // helper(nums, index+1, new ArrayList(path));
        // path.remove(path.size()-1);
    }
}
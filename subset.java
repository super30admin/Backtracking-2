// Time Complexity : Exponential
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        
        helper(nums, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path){
        //base
        if(nums.length == index){
            result.add(new ArrayList<>(path));
            return;
        }
        //choose
        path.add(nums[index]);
        helper(nums, index+1, path);
        path.remove(path.size()-1);
        
        //not choose
        helper(nums, index+1, path);
    }
}
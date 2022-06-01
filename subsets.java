// Time Complexity : O(2^N)
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    List<List<Integer>> result =new ArrayList<>();
    int j;
    public List<List<Integer>> subsets(int[] nums) {
        for(j=0;j<=nums.length;j++){
            helper(nums, 0, new ArrayList<>());
        }
        
        return result;
    }
    
    private void helper(int[] nums, int pivot, List<Integer> path){
        //base
        if(path.size()==j){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=pivot;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}
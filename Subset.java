// Time Complexity : O(N * 2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index,List<Integer> path){
        // result.add(path);
        // for(int i = index; i < nums.length ; i++){
        //     List<Integer> temp = new ArrayList<>(path);
        //     temp.add(nums[i]);
        //     helper(nums,i+1,temp);
        // }
        //Base
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        // Recurse and Action
        //Dont Choose
        helper(nums,index+1,path);
        //Choose
        path.add(nums[index]);
        helper(nums,index+1,path);
        //Backtrack
        path.remove(path.size()-1);
    }
}

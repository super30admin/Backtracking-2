// Time Complexity :exponential
// Space Complexity :(O(1)) for backtracking
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//recursion solution
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }
    public void helper(int[] nums, int index, List<Integer> path){
        
       //logic
        result.add(new ArrayList<>(path));
        //adding to the path
        for(int i=index;i<nums.length;i++){
           path.add(nums[i]); 
           helper(nums,i+1,path);
           path.remove(path.size()-1);
        }
    }
}
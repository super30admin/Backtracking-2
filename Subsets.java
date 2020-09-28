// Time Complexity : O(n^n) 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        backtracking(output,nums,0,path);
        
        return output;
    }
    
    public void backtracking(List<List<Integer>>output, int[] nums, int index, List<Integer> path){
        
        if(index>nums.length){
            output.add(new ArrayList(path));
            return;
        }
        
         output.add(new ArrayList(path));
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            backtracking(output,nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}
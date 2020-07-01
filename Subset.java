// Time Complexity : n2^n
//Space Complexity : o(n)
//Did this code successfully run on Leetcode : Yes
//---------Back Track-------------
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        backTrack(nums, new ArrayList<>(), 0 );
        return result;
    }
    
    public void backTrack(int[] nums, List<Integer> temp, int start){
        
        //base
        
        
        result.add(new ArrayList<>(temp));
        //logic 
        for(int i = start; i < nums.length; i++){
        //action
        temp.add(nums[i]);
        //recurse
        backTrack(nums, temp, i + 1);
        //backtrack
            temp.remove(temp.size() -1);
        }
        
    }
}
// Time Complexity :O(n2^n) n is the length of the nums array
// Space Complexity :O(n) n is the length of the nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :I'm confused with the time and space complexity


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length ==0) return result;
        backtrack(nums, new ArrayList<>() , 0);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> temp,int index){
        
        //logic
        //action
        result.add(new ArrayList<>(temp));
        
        for(int i=index;i<nums.length;i++){
            //action
            temp.add(nums[i]);
            
            //recurse
            backtrack(nums,temp,i+1);
            
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}
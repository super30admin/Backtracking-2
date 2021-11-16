// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        result.add(new ArrayList());
        List<Integer> list=new ArrayList<>();
        helper(nums, 0,list);
        return result;
    }
    
    public void helper(int[] nums, int index, List<Integer> currList){
        if(index==nums.length){
            return;
        }
        
        for(int i=index; i<nums.length;i++){
            currList.add(nums[i]);
            helper(nums, i+1, currList);
            result.add(new ArrayList(currList));
            currList.remove(currList.size()-1);
        }
    }
}
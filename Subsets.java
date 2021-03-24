// Time Complexity : O(n*2^n) where n is the input array length, 2^n - possible number of subsets
// Space Complexity : O(n) used for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        helper(nums,0,list);
        return result;
    }
    public void helper(int[] nums, int start,List<Integer> list){
        result.add(new ArrayList(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            helper(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }
}

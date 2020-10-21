// Time Complexity : O(N) - As we iterate through the whole Array
// Space Complexity : O(N) - AS We use recursion(backtracking)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) return res;
        backtrack(0,new ArrayList<Integer>(),nums);
        return res;
    }
    public void backtrack(int start,ArrayList curr,int[] nums){
        res.add(new ArrayList<Integer>(curr));
        for(int i = start;i < nums.length;i++){
            curr.add(nums[i]);
            backtrack(i+1,curr,nums);
            curr.remove(curr.size() - 1);
        }
    }
}
// Your code here along with comments explaining your approach
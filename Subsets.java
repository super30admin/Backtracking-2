// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a backtack method, we can either choose an index element or not choose
// When not choosing we can backtrack by removing element from subset
// When index value becomes equal to the length of nums we can make copy of the subset
// and add it to the ans list.

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList();
        backtrack(nums, 0, new ArrayList());
        return ans;
    }
    private void backtrack(int[] nums, int index, List<Integer> subset){
        //base
        if(index == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        //choose
        subset.add(nums[index]);
        backtrack(nums, index + 1, subset);
        //not choose
        subset.remove(subset.size()-1);
        backtrack(nums, index + 1, subset);
        
    }
}
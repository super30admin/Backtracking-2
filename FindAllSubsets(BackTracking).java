// Time Complexity : O(2^n) since each element could be absent or present.
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yeah finding Space Complexity


// Your code here along with comments explaining your approach

// Using Recursion on choose not choose along with back tracking


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
      
        helper(nums,0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums,int pivot, List<Integer> currSet)
    {
        //base
        if(pivot == nums.length )
        {
            result.add(new ArrayList<>(currSet));
            return;
        }
        // logic
        // not choose
            helper(nums,pivot+1,currSet);
            // choose
             currSet.add(nums[pivot]);
             helper(nums,pivot+1,currSet);
        currSet.remove(currSet.size()-1);
    }
}

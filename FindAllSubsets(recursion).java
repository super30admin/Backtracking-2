// Time Complexity : O(2^n) since each element could be absent or present.
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yeah finding Time Complexity, 


// Your code here along with comments explaining your approach

// using recursion choose and not choose technique


class Solution {
    List<List<Integer>> result;// = new List<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        //result.add(new ArrayList<>());
        helper(nums,0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums,int pivot, List<Integer> currSet)
    {
        //base
        if(pivot == nums.length )
        {
            result.add(currSet);
            return;
        }
        // logic
        // not choose
            helper(nums,pivot+1,new ArrayList<>(currSet));
            // choose
        currSet.add(nums[pivot]);
             helper(nums,pivot+1,new ArrayList<>(currSet));
    }
}

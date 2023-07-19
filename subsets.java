// Time Complexity :  O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// We use a for loop based recursion to iterate throught the array to get different subsets.

class Solution {
    List<List<Integer>>  result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int pivot,  List<Integer> path )
    {
        //base

        //logic
        result.add(new ArrayList<>(path));
        for(int i=pivot;i<nums.length;i++)
        {
            //action
            path.add(nums[i]);

            //recurse
            helper(nums,i+1, path);

            // backtrack
            path.remove(path.size()-1);
        }
    }
}
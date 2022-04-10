// Time Complexity : O(n * 2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {

    //code 4 : for loop recursion with backtracking

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {

        result = new ArrayList();
        helper(nums, 0, new ArrayList());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path)
    {
        //base
        result.add(new ArrayList(path));

        //logic
        for(int i=index; i<nums.length; i++)
        {
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i+1, path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}

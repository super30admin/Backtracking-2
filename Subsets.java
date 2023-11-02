// Time Complexity : O(N2^N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Subsets
{
    // For loop solution
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> subsets(int[] nums)
    {
        result.add(new ArrayList());
        for(int i =0; i < nums.length; i++)
        {
            int size = result.size();
            for(int j = 0; j < size; j++)
            {
                List<Integer> path = new ArrayList(result.get(j));
                path.add(nums[i]);
                result.add(path);
            }
        }
        return result;
    }

    // Recursive solution
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> subsets(int[] nums)
    {
        helper(nums, 0, new ArrayList());
        return result;
    }

    void helper(int[] nums, int idx, List<Integer> path)
    {
        // base
        if(idx == nums.length)
        {
            result.add(new ArrayList(path));
            return;
        }

        // not choose
        helper(nums, idx +1, path);
        path.add(nums[idx]);
        helper(nums, idx +1, path);
        path.remove(path.size()-1);
    }
}

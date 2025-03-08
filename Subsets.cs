// time complexity - n*2^n
// space complexity - O(n)
public class Solution
{
    List<IList<int>> res;
    public IList<IList<int>> Subsets(int[] nums)
    {
        res = new List<IList<int>>();

        helper(nums, 0, new List<int>());
        return res;
    }

    public void helper(int[] nums, int pivot, List<int> path)
    {
        // base
        res.Add(new List<int>(path));

        //logic
        for (int i = pivot; i < nums.Length; i++)
        {
            path.Add(nums[i]);
            helper(nums, i + 1, path);
            path.RemoveAt(path.Count() - 1);
        }
    }
}
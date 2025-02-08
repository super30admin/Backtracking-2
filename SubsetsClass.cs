public class Solution
{
    IList<IList<int>> result;
    public IList<IList<int>> Subsets(int[] nums)
    {
        result = new List<IList<int>>();
        if (nums == null || nums.Length == 0)
        {
            return result;
        }

        Backtrack(nums, 0, new List<int>());
        return result;
    }
    public void Backtrack(int[] nums, int index, IList<int> path)
    {

        result.Add(new List<int>(path));
        for (int i = index; i < nums.Length; i++)
        {
            path.Add(nums[i]);
            Backtrack(nums, i + 1, path);
            path.RemoveAt(path.Count - 1);
        }
    }
}
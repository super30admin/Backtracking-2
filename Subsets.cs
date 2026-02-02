public class Solution
{
    public IList<IList<int>> Subsets(int[] nums)
    {
        List<IList<int>> result = new();
        result.Add(new List<int>());
        for (int i = 0; i < nums.Length; i++)
        {
            int size = result.Count;
            for (int j = 0; j < size; j++)
            {
                List<int> subset = new List<int>(result[j]);
                subset.Add(nums[i]);
                result.Add(subset);
            }
        }

        return result;
    }
}
//Time and space - O(n * 2^n)

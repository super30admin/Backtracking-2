/*
  Time complexity: O(2^n)
  Space complexity: O(n)

  Code ran successfully on Leetcode: Yes

*/

public class Solution {
    List<IList<int>> result;
    public IList<IList<int>> Subsets(int[] nums) {
        result = new();
        if(nums==null || nums.Length == 0)
            return result;
        
        subsets(nums,0, new List<int>());

        return result;
    }

    private void subsets(int[] nums, int index, List<int> r)
    {
        result.Add(new List<int>(r));

        for(int i=index;i<nums.Length;i++)
        {
            r.Add(nums[i]);
            subsets(nums,i+1,r);

            r.RemoveAt(r.Count-1);
        }
    }
}

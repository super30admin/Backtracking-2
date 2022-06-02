using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity : O(2^N) 
    // Space Complexity :O(N) 
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No 
    public class SubSets
    {
        IList<IList<int>> result;
        public IList<IList<int>> Subsets(int[] nums)
        {
            result = new List<IList<int>>();
            if (nums == null || nums.Length == 0) return result;
            helper(nums, 0, new List<int>());
            return result;
        }

        private void helper(int[] nums, int i, List<int> path)
        {
            //base
            if (i == nums.Length)
            {
                result.Add(new List<int>(path));
                return;
            }
            //logic
            //not choose
            helper(nums, i + 1, path);

            path.Add(nums[i]);
            //choose
            helper(nums, i + 1, path);

            //back track
            path.RemoveAt(path.Count - 1);
        }

        public IList<IList<int>> Subsets_NoRecursion(int[] nums)
        {
            IList<IList<int>> result = new List<IList<int>>();
            result.Add(new List<int>());

            for (int i = 0; i < nums.Length; i++)
            {
                int size = result.Count;
                for (int j = 0; j < size; j++)
                {
                    IList<int> current = new List<int>(result[j]);
                    current.Add(nums[i]);
                    result.Add(current);
                }
            }

            return result;
        }

    }
}

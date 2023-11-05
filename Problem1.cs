public class Subset
    {
        // Time Complexity : O(2^n)
        // Space Complexity : O(n) - depth of the tree
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        IList<IList<int>> result;
        public IList<IList<int>> Subsets(int[] nums)
        {
            result = new List<IList<int>>();
            helper(nums, 0, new List<int>());
            return result;
        }

        private void helper(int[] nums, int idx, List<int> path)
        {
            //base case
            //not needed as for loop is going to take care of pivot check

            //logic
            result.Add(new List<int>(path));
            for(int i = pivot; i < nums.Length; i++)
            {
                //action
                path.Add(nums[i]);
                //recurse
                helperForLoop(nums, i + 1, path);
                //backtrack
                path.RemoveAt(path.Count - 1);
            }
        }
}

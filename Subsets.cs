using System;
using System.Collections.Generic;
using System.Text;

namespace BackTracking
{
    //TC : O( n * 2^n)
    //SC: O(n) recursive stack
    class SubsetsLC
    {
        List<List<int>> result;
        public List<List<int>> Subsets(int[] nums)
        {
            result = new List<List<int>>();
            if (nums == null || nums.Length == 0)
            {
                return result;
            }
            recurse(nums, 0, new List<int>());
            return result;
        }

        private void recurse(int[] nums, int index, List<int> path)
        {
            //base
            if (index == nums.Length)
            {
                result.Add(path);
                return;
            }
            //logic
            ////choose case or 1 case
            //List<int> copy = new List<int>(path);
            //copy.Add(nums[index]);
            //recurse(nums, index + 1, copy);
            //Do not choose 0 case
            recurse(nums, index + 1, new List<int>(path));
            //choose case or 1 case
            path.Add(nums[index]);
            recurse(nums, index + 1, new List<int>(path));
        }
        private void backtrack(int[] nums, int index, List<int> path)
        {
            //base
            if (index == nums.Length)
            {
                result.Add(new List<int>(path));
                return;
            }
            //logic
            //Do not choose 0 case
            backtrack(nums, index + 1, path);
            //choose case or 1 case
            //action
            path.Add(nums[index]);
            //recurse
            backtrack(nums, index + 1, path);
            //backtrack
            path.RemoveAt(path.Count - 1);
        }

        /// <summary>
        /// Loop template
        /// </summary>
        /// <param name="nums"></param>
        /// <param name="index"></param>
        /// <param name="path"></param>
        private void RecurseOption2(int[] nums, int index, List<int> path) {
            //base

            //logic
            result.Add(path);
            for (int i = index; i < nums.Length; i++)
            {
                List<int> copy = new List<int>(path);
                copy.Add(nums[i]);
                recurse(nums, i + 1, copy);
            }
        }
        //Time Complexity: O( n * 2^n)
        private void backtrackOption2(int[] nums, int index, List<int> path)
        {//base

            //logic
            result.Add(new List<int>(path));
            for (int i = index; i < nums.Length; i++)
            {
                //action
                path.Add(nums[i]);
                //recurse
                backtrackOption2(nums, i + 1, path);
                //backtrack
                path.RemoveAt(path.Count - 1);
            }
        }
        //TC O(2^n)
        public List<List<int>> SubsetsGoogleFB(int[] nums)
        {
            List<List<int>> result = new List<List<int>>();
            if (nums == null || nums.Length == 0)
            {
                return result;
            }
            result.Add(new List<int>());
            foreach (int num in nums)
            {
                int size = result.Count;
                for (int i = 0; i < size; i++)
                {
                    List<int> temp = new List<int>(result[i]);
                    temp.Add(num);
                    result.Add(temp);
                }
            }
            return result;
        }
    }
}

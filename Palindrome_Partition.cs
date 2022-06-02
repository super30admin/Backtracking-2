using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity : O(N * 2^N) 
    // Space Complexity :O(N) 
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No 
    public class Palindrome_Partition
    {
        IList<IList<string>> result;
        public IList<IList<string>> Partition(string s)
        {
            result = new List<IList<string>>();
            if (s == null || s.Length == 0) return result;
            helper(s, 0, new List<string>());
            return result;
        }

        private void helper(string s, int idx, List<string> path)
        {
            //base
            if (idx == s.Length)
            {
                result.Add(new List<string>(path));
                return;
            }
            //logic

            for (int i = idx; i < s.Length; i++)
            {
                int length = i - idx;
                string sub = s.Substring(idx, length + 1);
                if (IsPalindrome(sub))
                {
                    //action
                    path.Add(sub);
                    //recurse
                    helper(s, i + 1, path);
                    //back track
                    path.RemoveAt(path.Count - 1);
                }
            }
        }

        private bool IsPalindrome(string s)
        {
            int start = 0;
            int end = s.Length - 1;
            while (start < end)
            {
                if (s.ToCharArray()[start] != s.ToCharArray()[end])
                    return false;
                start++;
                end--;
            }

            return true;
        }
    }
}

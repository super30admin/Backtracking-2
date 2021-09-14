using System;
using System.Collections.Generic;
using System.Text;

namespace BackTracking
{
    //TC : O( n * 2^n)
    //SC: O(n) recursive stack
    class FindPalidromePartitionLC
    {
        //TC : O(n * 2 ^n)
        //SC: O(n) recursive stack
        List<List<string>> result;
        public List<List<string>> Partition(string s)
        {
            result = new List<List<string>>();
            if (s == null || s.Length == 0)
            {
                return result;
            }
            recurse(s, 0, new List<string>());
            return result;
        }

        private void recurse(string s, int index, List<string> path)
        {
            //base
            if (s.Length == 0)
            {
                result.Add(path);
                return;
            }
            //logic
            for (int i = 0; i < s.Length; i++)
            {
                if (isPalindrome(s, 0, i))
                {
                    List<string> copy = new List<string>(path);
                    copy.Add(s.Substring(0, i + 1));
                    recurse(s.Substring(i + 1), i + 1, copy);
                }
            }
        }

        private bool isPalindrome(string s, int l, int r)
        {
            while (l < r)
            {
                if (s[l]  != s[r])
                {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
        //TC : O(n * 2 ^n)
        private void backtrack(string s,  List<string> path)
        {
            //base
            if (s.Length == 0)
            {
                result.Add(new List<string>(path));
                return;
            }
            //logic
            for (int i = 0; i < s.Length; i++)
            {
                if (isPalindrome(s, 0, i)){
                    //action
                    path.Add(s.Substring(0, i + 1));
                    //recurse
                    backtrack(s.Substring(i + 1), path);
                    //backtrack
                    path.RemoveAt(path.Count - 1);
                }
            }
        }

        private void backtrackOption2(string s, int index, List<string> path)
        {
            //base
            if (s.Length == index)
            {
                result.Add(new List<string>(path));
                return;
            }
            //logic
            for (int i = 0; i < s.Length; i++)
            {
                if (isPalindrome(s, index, i)){
                    //action
                    path.Add(s.Substring(index, i + 1));
                    //recurse
                    backtrackOption2(s, i + 1, path);
                    //backtrack
                    path.RemoveAt(path.Count - 1);
                }
            }
        }
    }
}

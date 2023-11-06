public class PalindromePartitioning
    {
        // Time Complexity : O(n * 2^n)
        // Space Complexity : O(n) - depth of the tree - length of the string
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        IList<IList<string>> result;
        public IList<IList<string>> Partition(string s)
        {
            result = new List<IList<string>>();
            helper(s, 0, new List<string>());
            return result;

        }

        private void helper(string s, int pivot, List<string> path)
        {
            //base case
            if (pivot == s.Length)
            {
                result.Add(new List<string>(path));
            }

            //logic
            for(int i = pivot; i < s.Length; i++)
            {
                string subStr = s.Substring(pivot, (i - pivot) + 1);
                //check if substring is palindrome
                if(isPalindrome(subStr))
                {
                    //action
                    path.Add(subStr);
                    //recurse
                    helper(s, i + 1, path);
                    //backtrack
                    path.RemoveAt(path.Count - 1);

                }
            }
        }

        private bool isPalindrome(string s)
        {
            int start = 0;
            int end = s.Length - 1;
            while(start < end)
            {
                if (s[start] != s[end])
                    return false;

                start++;
                end++;
            }
            return true;
        }
}

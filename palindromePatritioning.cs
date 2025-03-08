// time complexity - n*2^n
// space complexity - O(n)
public class Solution
{
    List<IList<string>> res;
    public IList<IList<string>> Partition(string s)
    {
        res = new List<IList<string>>();
        helper(s, 0, new List<string>());
        return res;
    }
    private void helper(string s, int start, List<string> path)
    {
        // base
        if (start >= s.Length)
        {
            res.Add(new List<string>(path));
        }
        // logic
        for (int i = start; i < s.Length; i++)
        {
            if (isPal(s, start, i))
            {
                path.Add(s.Substring(start, i - start + 1));//(substring(s,start,i+1));

                // recurse
                helper(s, i + 1, path);
                //backtrack
                path.RemoveAt(path.Count() - 1);
            }
        }
    }
    private bool isPal(string s, int start, int end)
    {
        while (start <= end)
        {
            if (s[start] != s[end])
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
public class Solution
{
    IList<IList<string>> result;
    public IList<IList<string>> Partition(string s)
    {
        result = new List<IList<string>>();
        if (string.IsNullOrEmpty(s))
        {
            return result;
        }

        Recurse(s, 0, new List<string>());
        return result;
    }
    public void Recurse(string s, int index, IList<string> path)
    {
        if (index == s.Length)
        {
            result.Add(new List<string>(path));
            return;
        }

        //logic

        for (int i = index; i < s.Length; i++)
        {
            var newStr = s.Substring(index, i + 1 - index);
            if (IsPalindrome(newStr))
            {
                path.Add(newStr);
                Recurse(s, i + 1, path);
                path.RemoveAt(path.Count - 1);
            }

        }

    }
    public bool IsPalindrome(string s)
    {
        int left = 0, right = s.Length - 1;
        while (left <= right)
        {
            if (s[left] != s[right])
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
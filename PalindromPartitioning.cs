public class Solution {
    public IList<IList<string>> Partition(string s) {
        List<IList<string>> result = new ();
        helper(s,0,new List<string>(),result);
        return result;
    }

    public void helper(string s,int pivot,List<string> path, List<IList<string>> result)
    {
        if(s.Length==pivot)
            {
                result.Add(new List<string>(path));
                return;
            }
        for(int i=pivot;i<s.Length;i++)
        {
            string curstr = s.Substring(pivot,i-pivot + 1);
            if(IsPalindrome(curstr))
            {
                path.Add(curstr);
                helper(s,i+1,path,result);
                path.RemoveAt(path.Count - 1);
            }
        }
    }
    public bool IsPalindrome(string s)
    {
        int i = 0 ;int j = s.Length - 1;
        while(i <= j)
        {
            if(s[i++]!=s[j--])
            {
                return false;
            }
        }
        return true;
    }
}
// Time Complexity:
// O(2^n * n) -> For n length string, exponential partitions × (palindrome checks + creating substrings)

// Space Complexity:
// O(n^2) (substring creation and recursion stack)
/*
  Time complexity: O(2^n)
  Space complexity: O(n)

  Code ran successfully on Leetcode: Yes

*/

public class Solution {
    public IList<IList<string>> Partition(string s) {
        List<IList<string>> result = new();

        helper(s,0,new List<string>(),result);
        return result;
    }

    private void helper(string s, int pivot, List<string> path, List<IList<string>> result)
    {
        //base
        if(s.Length == pivot)
        {
            result.Add(new List<string>(path));
            return;
        }
        //logic
        for(int i=pivot;i<s.Length;i++)
        {
            String current = s.Substring(pivot,i-pivot+1);
            if(isPalindrome(current))
            {
                path.Add(current);
                helper(s,i+1,path,result);
                path.RemoveAt(path.Count - 1);
            }
        }
    }

    private bool isPalindrome(string s)
    {
        int l = 0;
        int r = s.Length-1;
        while(l<r)
        {
            if(s[l]!=s[r])
                return false;

            l++;
            r--;
        }
        return true;
    }
}

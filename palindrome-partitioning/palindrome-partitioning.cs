public class Solution {
    List<IList<string>> result;
    public IList<IList<string>> Partition(string s) {
        result = new List<IList<string>>();
        if(s.Length==0 || s==null) return result;
        
        helper(s,new List<string>(),0);
        return result;
        
    }
    private void helper(string s,List<string> temp, int index)
    {
        if(index==s.Length)
        {
            result.Add(new List<string>(temp));
            return;
        }
        
        for(int i=index;i<s.Length;i++)
        {
            if(ispalindrome(s,index,i))
            {
                Console.WriteLine(index);
                Console.WriteLine(i+1);
                temp.Add(s.Substring(index,i-index+1));
                helper(s,temp,i+1);
                temp.RemoveAt(temp.Count-1);
            }
        }
    }
    
    private bool ispalindrome(string s,int low,int high)
    {
        while(low<high)
        {
            if(s[low++] != s[high--]) return false;
        }
        return true;
    }
}

// Time Complexity : O(N*2^n),  N is for palindrom each string and 2^n because we make two decision at each step to move forward or not
// Space Complexity : O(n), store the recursive stack 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

List<IList<string>> result;
public IList<IList<string>> Partition(string s) {
    
    result = new List<IList<string>>();
    if(String.IsNullOrEmpty(s))
        return result;
    
    helper(s, 0, new List<string>());
    
    return result;
}

private void helper(string s, int index, List<string> path)
{
    //base
    if(index == s.Length)
    {
        result.Add(new List<string>(path));
        return;
    }
    
    //logic
    for(int i = index; i < s.Length; i++)
    {
        //chekc if string is palindrom
        if(isPalindrome(s, index, i))
        {
            //add to current path
            //action
            path.Add(s.Substring(index, i+1-index));
            //recursion call
            helper(s, i+1, path);
            //backtrack
            path.RemoveAt(path.Count -1);
        }
    }
}

//check is passed string is palindrome
private bool isPalindrome(string s, int l, int r)
{
    while(l <= r)
    {
        if(s[l] != s[r])
            return false;
        l++;
        r--;
    }
    return true;
}
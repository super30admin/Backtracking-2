// Time Complexity : o( n * 2^n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    List<List<String>> res;
    List<String> path;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(s, 0, path);
        return res;
    }
    private void helper(String s, int index, List<String> path)
    {
        //base
        if(index == s.length())
        {
            res.add(new ArrayList(path));
            return;
        }
        
        //logic
        for(int i = index; i<s.length(); i++)
        {
            if(ispalindrome(s, index, i))
            {
                path.add(s.substring(index, i+1));
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean ispalindrome(String s, int l, int r)
    {
        if(l==r) return true;
        while(l < r)
        {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
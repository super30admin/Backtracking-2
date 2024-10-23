// Time Complexity : O(2^n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    //aesha
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return result;
    }
    private void helper(String s, int pivot, List<String> path)
    {   
        if(pivot == s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = pivot; i<s.length();i++)
        {
            String st = s.substring(pivot, i+1);
            if(isPalindrome(st))
            {
                path.add(st);
                helper(s, i+1,path);
                path.remove(path.size()-1);
            }
        }

    }
    private Boolean isPalindrome(String s)
    {
        
        int l=0,r=s.length()-1;
        while(l<r)
        {
            if(s.charAt(l) != s.charAt(r))
            {
                return false;
            }
            l++; r--;
        }
        return true;
    }
}
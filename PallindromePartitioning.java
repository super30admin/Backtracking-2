//https://leetcode.com/problems/palindrome-partitioning/
// Time Complexity :O(exponential) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
     List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        if(s==null || s.length()==0)
            return result;
        helper(s,0,new ArrayList<>());
        return result;
        
    }
    private void helper(String s, int idx, List<String> path)
    {
        //base
        if(idx==s.length())
        {
            result.add(new ArrayList<>(path));
            //no need of return statement as we are back tracking
        }   
        
        //logic
        for(int i=idx;i<s.length();i++)
        {
            String sub=s.substring(idx,i+1); //initially substring is single element when i moves check for substring being pallindrome if not dont recurse
            if(pallindrome(sub)){
                path.add(sub);
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean pallindrome(String s)
    {
        int start=0;
        int end=s.length()-1;
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
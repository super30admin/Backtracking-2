// Time Complexity :O(2^n) n-length of the String
// Space Complexity :O(n)  
// Did this code successfully run on Leetcode :yes
//backtracking
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        if(s==null || s.length()==0) return result;
        backtrack(s,0,new ArrayList<>());
        return result;
    }
    private void backtrack(String s,int start,List<String> str)
    {
        if(start==s.length())
        {
           result.add(new ArrayList<>(str));
           return;
        }
            
        
        for(int i=start;i<s.length();i++)
        {
            if(palindrome(s,start,i))
            {
                str.add(s.substring(start,i+1));
                backtrack(s,i+1,str);
                str.remove(str.size()-1);
                
            }
        }
    }
    
    private boolean palindrome(String s, int l, int r)
    {
        if(l==r) return true;
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
                return false;
            r--;l++;
        }
        return true;
    }
}

//Recursion
/*
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        if(s==null || s.length()==0) return result;
        backtrack(s,0,new ArrayList<>());
        return result;
    }
    private void backtrack(String s,int start,List<String> str)
    {
        if(start==s.length())
        {
           result.add(new ArrayList<>(str));
           return;
        }
            
        
        for(int i=start;i<s.length();i++)
        {
            if(palindrome(s,start,i))
            {
                List<String> l=new ArrayList<>(str);
                l.add(s.substring(start,i+1));
                backtrack(s,i+1,l);
                
                
            }
        }
    }
    
    private boolean palindrome(String s, int l, int r)
    {
        if(l==r) return true;
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
                return false;
            r--;l++;
        }
        return true;
    }
}
*/
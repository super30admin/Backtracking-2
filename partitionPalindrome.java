class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        
        result= new ArrayList<>();
        
        if(s==null || s.length()==0) return result;
        
        helper(s,new ArrayList<>(),0);
        
        return result;
        
    }
    
    private void helper(String s,List<String> list,int idx)
    {
        //base
        if(idx==s.length())
            result.add(new ArrayList<>(list));
        
        
        //logic
        for(int i=idx;i<s.length();i++)
        {
            String cur=s.substring(idx,i+1);
            if(Check(cur))
            {   
                list.add(cur);
                helper(s,list,i+1);
                list.remove(list.size()-1);
            }
        }
        
    }
    
    private boolean Check(String str)
    {
        String rev = "";
 
        boolean ans = false;
 
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
 
        if (str.equals(rev)) {
            ans = true;
        }
        return ans;
        
    }
}

// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
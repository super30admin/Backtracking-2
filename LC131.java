class Solution {
    
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        
        result = new ArrayList<>();
        
        if(s==null || s.length()==0)
        {
            return result;
        }
        
        helper(s,0,new ArrayList<>());
        
        return result;
    }
    
    public void helper(String s, int index, List<String> path)
    {
        //base
        if(index==s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        
        for(int i = index;i<s.length();i++)
        {

            String curr = s.substring(index,i+1);
            if(isPalindrome(curr))
            {
                //action
                path.add(curr);

                //recurse
                helper(s,i+1,path);

                //backtrack
                path.remove(path.size()-1);
            }
            
        }
        
        return;
    }
    
    public boolean isPalindrome(String str)
    {
        int start = 0;
        int end = str.length()-1;
        
        while(start<end)
        {
            if(str.charAt(start)!=str.charAt(end))
            {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}
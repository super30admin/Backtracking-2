class Solution {
    //tc- n2n(n+n2n=> n for checking if palindrome for each node, n for creating substring)
    //sc- n2n

    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null) return result;
        helper(s,0,0,new ArrayList<>());
        return result;
        
    }
    private void helper(String s,int idx,int i,List<String> path)
    {
        //base case
         if(idx == s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        if(i == s.length())
        {
   
            return;
        }
       
      
        //logic
        //not choose
        helper(s,idx,i+1,path);
        //choose
        String sub = s.substring(idx,i+1);
        if(isPalindrome(sub))
        {
            //action
        path.add(sub);
            //recurse
        helper(s,i+1,i+1,path);
            //backtrack
            path.remove(path.size()-1);
        }
        
    }
    private boolean isPalindrome(String s)
    {
        int start = 0;
        int end = s.length()-1;
        while(start<end)
        {
            if(s.charAt(start) != s.charAt(end))
                return false;
            else
            {
                start++;
                end--;
            }
        }
        return true;
    }
}
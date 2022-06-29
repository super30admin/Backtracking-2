//Time 2^n *n

class Solution {List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        
        helper(s,new ArrayList<String>(),0);
        
        return result;
    }
                
                
   private void helper(String s, ArrayList<String> path, int index)
   {
       
       if(index>=s.length())
       {result.add(new ArrayList<>(path));
        return;
       }
       
       for(int i=index;i<s.length();i++ )
       {
           
           String temp = s.substring(index,i+1);
           
           if(palindrome(temp))
           {   path.add(temp);
               helper(s, path, i+1);
            path.remove(path.size()-1);
           }
           
           
       }
       
   }
    
    private boolean palindrome(String s)
    {
        int start =0;
        int end = s.length()-1;
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++; end--;
        }
        return true;
        
        
        
        
    }
    
    
}
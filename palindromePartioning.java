// Time - O(2^n) decision for each element
// Space - O(n)  at most n in list

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0)
            return new ArrayList<>();
        
        result=new ArrayList<>();
        
        helper(0,s,new ArrayList<>());
        
        return result;
    }
    
    private void helper(int index, String s, List<String> temp) 
    {
        /* Base Case */
        if(index==s.length())
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        /* Backtrack */
        
        for(int i=index; i<s.length();i++)
        {
            /* Get current string */
            String current=s.substring(index,i+1);
            /* Check if its a palindrome */
            if(checkPalindrome(current))
            {
                /* Action */
                temp.add(current);
                /* Recurse */
                helper(i+1,s,temp);
                //helper(i+1,s,temp);
                /* Backtrack */
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean checkPalindrome(String s)
    {
        int start=0;
        int end=s.length()-1;
        
        while(start<=end)
        {
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        
        return true;
    }
}
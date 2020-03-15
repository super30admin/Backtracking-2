//Time Complexity: O(n2^n)
//Space Complexity: O(n)

class Solution {
    
    List<List<String>> result = null;
    
    public List<List<String>> partition(String s) {
        
       result = new ArrayList<>();
       backtrack(s, 0, new ArrayList<>());
    
       return result;
    }
    
    
    private void backtrack(String s, int index, List<String> temp)
    {
        if(index == s.length())
        {
        	result.add(new ArrayList<>(temp));
        	return; 
        }
        	
        	
        for(int i=index; i<s.length(); i++)
        {
            String str = s.substring(index, i+1);
            if(isPalindrome(str))
            {
            	 System.out.print("String ?"+str+" ");
                 temp.add(str);  
                 backtrack(s, i+1, temp);
                 temp.remove(temp.size()-1);
            }
        }
        
    }
    
    
    private boolean isPalindrome(String str)
    {
        if(str == null || str.length()==0 || str.length()==1)
            return true;
        
        int j=str.length()-1;
        char[] ch = str.toCharArray();
        for(int i=0; i<j; i++)
        {
            if(ch[i]!=ch[j])
                return false;
            j--;
        }
        
        return true;
    }
}

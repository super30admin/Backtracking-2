class Solution { 
    List<List<String>> output;
    public List<List<String>> partition(String s) {
        
        output = new ArrayList<>();
        helper(0,s,new ArrayList<>());
        return output;
    }
    
    private void helper(int start, String s, ArrayList<String> temp)
    {
        if(start >=s.length())
            output.add(new ArrayList<>(temp));
        for(int i = start; i<s.length(); i++)
        {
            String substr = s.substring(start,i+1);
            if(isPalindrome(s,start,i))
            {
                temp.add(substr);
                helper(i+1, s, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end)
    {
        while(start < end)
        {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}

//TC- O(N*2^N)
//SC- O(N*2^N)

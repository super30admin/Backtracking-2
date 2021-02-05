/**
Time Complexity : O(N*N)
Space Complexity : O(N*N) considering the recursion stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/

class Solution 
{

    private List<List<String>> output;
    
    public List<List<String>> partition(String s) 
    {
        this.output = new ArrayList<>();   
        
        this.palindromePartition(s, new ArrayList<>());
        
        return this.output;
    }
    
    private void palindromePartition(String input, List<String> currentList)
    {
        if( input.isEmpty())
        {
            this.output.add(currentList);
            return;
        }
        
        for( int i =1; i <= input.length(); i++)
        {
            String left = input.substring(0, i);
            String right = input.substring(i);
            
            // check if the left string is a palindrome
            boolean isPalindrome = checkPalindrome(left);
            
            if(isPalindrome)
            {
                List<String> newList = new ArrayList<>(currentList);
                newList.add(left);
                
                palindromePartition(right, newList);
            }
        }
        
        
    }
    
    private boolean checkPalindrome(String input)
    {
    
        int start =0;
        int end = input.length() -1;
        
        while( start < end )
        {
            if( input.charAt(start) != input.charAt(end))
                return false;
                
            start++;
            end--;
        
        }
        
        
        return true;
    
    }
}
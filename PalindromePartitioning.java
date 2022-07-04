/*
This solution uses the for loop based recursion to find all the valid palindromes. It succesively iterates throughout the
input string and builds up the solution space by checking whether the currently chosen element/permutation is a palindrome 
or not before checking further to add to the final result

Did this code run on leetcode: Yes
*/
class Solution {
    List<List<String>> result;
    //Time Complexity: O(2^n)
    //Space Complexity: n
    public List<List<String>> partition(String s) {
        
        result = new ArrayList<>();
        
        helper(s, new ArrayList<>());
        
        return result;
        
    }
    
    private void helper(String s, List<String> path)
    {   
        if(s.length() == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = 0; i < s.length(); i++)
        {
            String subString = s.substring(0, i + 1);
            
            if(isPalindrome(subString))
            {
                path.add(subString);
                //The function call passes the substring ahead of the current substring, so that we optimise the space 
                //further compared to passing the whole string again and iterating over it.
                helper(s.substring(i+1), path);
                
                path.remove(path.size() - 1);
            }
        }
    }
    //Palindrome checking function
    private boolean isPalindrome(String s)
    {
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end)
        {
            if(s.charAt(start) != s.charAt(end))
                return false;
            
            start++;
            end--;
        }
        
        return true;
    }
}
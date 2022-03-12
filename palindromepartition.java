/**
s = "aab"
a,a,b
aa,b
a,ab

TC = 2^N * N where N is the length of the string.
SC =  O(N) N is the maximum depth of the stack.
**/
class Solution {
    
    List<List<String>> results = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        palindromePartition(0, new ArrayList<>(), s);
        return results;
    }
    
    private void palindromePartition(int start, List<String> partitionSet, String s)
    {
        // base case
        if (start == s.length())
        {
            results.add(new ArrayList<>(partitionSet));
        }
        
        for (int i=start; i<s.length(); i++)
        {
            //choose 
            String substring = s.substring(start,i+1);
            
            if (isPalindrome(substring))
            {
                partitionSet.add(substring);
                //recur
                palindromePartition(i+1, partitionSet, s);
                //backtrack
                partitionSet.remove(partitionSet.size() - 1);
            }
        }
    }
    
    // abba
    
    private boolean isPalindrome(String input)
    {
        int start = 0;
        int end = input.length() - 1;
        
        while (start < end)
        {
            if (input.charAt(start) != input.charAt(end))
            {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}

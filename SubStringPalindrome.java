//Time C: O(N*2^N)
//Space C: O(N)
//Executed on leetcode.
class Solution {
    List<List<String>> output =new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0,new ArrayList<String>());
        
        return output;
    }
    private void backtracking(String s, int index, List<String> palStrs)
    {
        if(index==s.length())
        {
            output.add(new ArrayList<>(palStrs));   
            
        }
        for(int i=index;i<s.length();i++)
        {
            String curr = s.substring(index,i+1);   //Getting the current string and if the string is a palindrome adding to the list and upon completing the one index value adding the list to output list.
            if(isPalindrome(curr))
            {
                palStrs.add(curr);
                backtracking(s,i+1,palStrs);
                palStrs.remove(palStrs.size()-1);
            }
            
        }
    }
    
    public boolean isPalindrome(String s)
    {
        int l = 0, r = s.length()-1;
        while(l<=r)
        {
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
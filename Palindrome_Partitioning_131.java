//Time Complexity : O(m^n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

import java.util.List;
import java.util.ArrayList;

class Palindrome_Partitioning_131 {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length() == 0)
            return result;
        helper(s, new ArrayList<>(), 0);
        return result;
    }
    
    private void helper(String str, List<String> temp, int index)
    {
        // Base
        if(index == str.length())
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        // Logic
        for(int i = index; i < str.length(); i++)
        {
            if(isPalindrome(str, index, i))
            {
                // Action
                temp.add(str.substring(index, i+1));
                // Recurse
                helper(str, temp, i+1);
                // Backtrack
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str, int left, int right)
    {
        if(left == right)
            return true;
        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

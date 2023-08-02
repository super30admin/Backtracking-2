package BackTracking;

// Time Complexity : O(2^n))
// Space Complexity : O(n)  ->height of thee stack
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningUsing01Recursion {

    List<List<String>> result;
    List<String> path;
    public List<List<String>> partition(String s) {

        result = new ArrayList<>();
        path = new ArrayList<>();

        helper(s,0,0,0);
        return result;
    }

    private void helper(String s, int pivot, int i,int sum)
    {
        if(i == s.length())
        {
            if(sum == s.length())
            {
                result.add(new ArrayList(path));
            }
            return;
        }
        //not choose
        helper(s,pivot,i+1, sum);

        //choose
        String sub = s.substring(pivot,i+1);
        if(isPalindrome(sub))
        {
            path.add(sub);
            helper(s,i+1,i+1, sum+sub.length());
            path.remove(path.size()-1);
        }

    }

    private boolean isPalindrome(String s)
    {
        int start = 0;
        int end = s.length()-1;

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

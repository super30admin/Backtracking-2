
// Time Complexity : O(2*N)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


import java.util.*;
class PalindromePartitioning {

    List<List<String>> res;
    public List<List<String>> partition(String s) {

        res = new ArrayList<>();

        if(s==null || s.length()==0)
        {
            return res;
        }

        helper(s,new ArrayList<>());

        return res;

    }

    public void helper(String s, List<String> lst)
    {
        // base case 
        if(s.length()==0)
        {
            res.add(new ArrayList<>(lst));
            return;
        }

        // logic
        for(int i=0;i<s.length();i++)
        {
            if(isPalindrome(s,0,i))
            {
                // action add
                lst.add(s.substring(0,i+1));

                // recursion
                helper(s.substring(i+1),lst);

                // bactrack
                lst.remove(lst.size()-1);

            }


        }

    }

    public boolean isPalindrome(String s,int left, int right)
    {
        while(left<right)
        {
            if(s.charAt(left)!=s.charAt(right))
            {
                return false;
            }
            left++;
            right--;


        }
        return true;
    }



}
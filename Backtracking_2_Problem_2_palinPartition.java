//Time complexity : O(n*2^n) (Ignoring the complexity of checking if its palindrome)
//Space Complexity : O(n*2^n)
//Runs successfully on leetcode
//No problem

//Here we will be recursively calling the function on indexing
//After reaching to one solution we'll backtrack for finding other possible solutions

import java.util.ArrayList;
import java.util.List;

public class Backtracking_2_Problem_2_palinPartition {
    List<List<String>> list;
    public List<List<String>> partition(String s) {
        list = new ArrayList<>();
        helper(s,new ArrayList<>(),0);
        return list;
    }

    public void helper(String s,ArrayList<String> arr,int index)
    {
        if(index == s.length())
        {
            list.add(new ArrayList<>(arr));
        }
        for(int i = index; i < s.length() ; i ++)
        {
            if(isPalindrome(s,index,i))
            {
                arr.add(s.substring(index,i+1));
                helper(s,arr,i+1);
                arr.remove(arr.size()-1);
            }
        }
    }


    public boolean isPalindrome(String s, int l,int r)
    {
        if(l == r) return true;
        while(l<r)
        {
            if(s.charAt(l) != s.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

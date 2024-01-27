import java.util.ArrayList;
import java.util.List;

// for loop based recursion with backtracking
// Time Complexity : O(2^n)  n is the length of the input array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Y 
// Any problem you faced while coding this :

public class Palindrome {
     List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return result;

    }

    public void helper(String s, int pivot, List<String> path)
    {
        if(pivot == s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = pivot; i < s.length(); i++)
        {
            String sub = s.substring(pivot,i+1);
            if(isPalindrome(sub))
            {
                path.add(sub);
                helper(s, i+1, path);
                path.remove(path.size() -1);
            }
        }
    }
        private boolean isPalindrome(String s)
        {
            int start = 0;
            int end = s.length()-1;
            while(start < end)
            {
                if(s.charAt(start) != s.charAt(end))
                {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
        public static void main(String[] args)
        {
            String s = "aab";
            Palindrome cs = new Palindrome();
            System.out.println(cs.partition(s).toString());
        }
}

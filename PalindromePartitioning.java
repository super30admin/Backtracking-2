import java.util.ArrayList;
import java.util.List;
//Idea is to use exhaustive approach to generate all the sub strings possible and 
// continue forming subsequent sub strings only if the current sub string is valid.

//Time Complexity: O(n*(2^n))
//Space Complexity: O(n^2)
public class PalindromePartitioning {
        private List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, new ArrayList<String>());
        return result;
    }

    public void helper(String s, List<String> path)
    {
        if(s.length()==0)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<s.length();i++)
        {
            String temp = s.substring(0,i+1);
            if(isPalindrome(temp)){
            path.add(temp);
            helper(s.substring(i+1),path);
            path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s)
    {
       int l = 0, r= s.length()-1;

       while(l<=r)
       {
        if(s.charAt(l)==s.charAt(r))
        {
            l++;
            r--;
        }
        else
        {
            return false;
        }
       }
       return true;
    }
}

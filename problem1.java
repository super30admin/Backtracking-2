import java.util.ArrayList;
import java.util.List;
// Time Complexity: O((n+n)*2^n)
// Space Complexity: O(n* 2^n) + O(n), stack space
public class problem1 {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        this.res= new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return res;
    }
    private  void helper(String s, int pivot, List<String> path)
    {
        // base case
        if (pivot==s.length())
        {
            res.add(new ArrayList<>(path));
            return;
        }
        //logic
        for (int i=pivot;i<s.length();i++)
        {
            String subStr= s.substring(pivot, i+1);
            if (isPalindrome(subStr))
            {
                path.add(subStr);
                helper(s,i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s)
    {
        int l=0, r=s.length()-1;
        while (l<r)
        {
            if (s.charAt(l)!=s.charAt(r))
            {
                return false;
            }
            l++; r--;
        }
        return true;
    }
}

import java.util.ArrayList;
import java.util.List;

public class palindrome {
    class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result=new ArrayList<>();
        helper(0,new ArrayList<>(),s);
        return result;
    }

    public void helper(int i, List<String> path,String s)
    {
        if(i==s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int j=i;j<s.length();j++)
        {
            String sb=s.substring(i,j+1);
            if(isPalin(sb))
            {
                path.add(sb);
                helper(j+1,path,s);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalin(String sb)
    {
        int i=0;
        int j=sb.length()-1;
        while(i<j)
        {
            if(sb.charAt(i)!=sb.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
}

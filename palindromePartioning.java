//time complexity: O(N * 2 ^ N)
//space complexity: O(N * 2 ^ N) 
import java.util.*;

class PalindromePartitionSolution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), s, 0);
        return result;    
    }
    
    public static void dfs(List<List<String>> result, List<String> list, String s, int start)   
    {
        if(s.length() == start)
            result.add(new ArrayList<>(list));
        else
        {
            for(int i = start; i < s.length(); i++)
            {
                if(isPalindrome(s, start, i))
                   { 
                    list.add(s.substring(start, i+1));
                    dfs(result, list, s, i+1);
                    list.remove(list.size() - 1);
                   }
            }
        }
        
    }
    
    public static boolean isPalindrome(String s, int start, int end)
    {
        while(end > start)
        {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        
        }
        return true;
    }


    public static void main(String[] args)
    {
        PalindromePartitionSolution pp=new PalindromePartitionSolution();
        pp.partition("aab");
    }
}
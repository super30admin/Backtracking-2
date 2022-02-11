// Time Complexity: o(n*2^n) -> o(2^n)
// Space Complexity: O(n*n) where n is length of string
// DP backtrack
public class PalindromePartitioning {
    List<List<String>> result;
    boolean dp[][];
    public List<List<String>> partition(String s)
    {
        result = new ArrayList<>();    
        if(s == null || s.length() == 0)
            return result;
        int n = s.length();
        
        dp = new boolean[n][n];
        
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0; j <= i ; j++)
            {
                
                if(s.charAt(i) == s.charAt(j) && (i-j <=1 || dp[i-1][j+1]))
                {
                    
                    dp[i][j] = true;
                }
                else
                {
                    dp[i][j] = false;
                }
                // System.out.print("\t" + dp[i][j] + "\t");   
            }
             // System.out.println();
        }
        
        
        backtrack(s, 0, new ArrayList<String>());
        
        return result;
    }
    
    private void backtrack(String s, int start, List<String> row)
    {
        if (start == s.length()) {
            result.add(new ArrayList<>(row));
            return;
        }
        
        for(int j = start; j < s.length(); j++)
        {
            if(dp[j][start])// is palindrome
            {
                row.add(s.substring(start, j+1));
                backtrack(s, j+1, row);
                row.remove(row.size() - 1);
            }
        }
    }
}
// Time Complexity: o(n*2^n) -> o(2^n)
// Space Complexity: O(n) where n is length of string
// iterative backtrack
public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s)
    {
        result = new ArrayList<>();    
        if(s == null || s.length() == 0)
            return result;
        
        iterativeBacktrack(s, 0, new ArrayList<>());
        
        return result;
    }
    
    
    private void iterativeBacktrack(String s , int index, List<String> curr)
    {
        // base
        if(index == s.length())
        {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        // recursive
        for(int i = index ; i < s.length(); i++) // O/1 case where 0 means move to next solution
        {
            String currPart = s.substring(index, i+1);
            if(isPalindrome(currPart)) // if current partition is a palindrome then partition further
            {
                curr.add(currPart);
                iterativeBacktrack(s, i+1 , curr);
                curr.remove(curr.size()-1);// backtrack
            }
        }      
    }

    private boolean isPalindrome(String s)
    {
        int l = 0, r = s.length()-1;
        while(l <= r)
        {
            if(s.charAt(l) == s.charAt(r))
            {
                l++;
                r--;
            }
            else
                return false;
        }
        return true;
    }
}

// Time Complexity: o(n*2^n) -> o(2^n)
// Space Complexity: O(n) where n is length of string
// iterative
public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s)
    {
        result = new ArrayList<>();    
        if(s == null || s.length() == 0)
            return result;
        
        iterative(s, 0, new ArrayList<>());
        
        return result;
    }
    
    
    private void iterative(String s , int index, List<String> curr)
    {
        // base
        if(index == s.length())
        {
            result.add(curr);
            return;
        }
        
        // recursive
        for(int i = index ; i < s.length(); i++)
        {
            String currPart = s.substring(index, i+1);
            if(isPalindrome(currPart)) // if current partition is a palindrome then partition further
            {
                List<String> currCopy = new ArrayList<>(curr);
                currCopy.add(currPart);
                iterative(s, i+1 , currCopy);
            }
        }      
    }

    private boolean isPalindrome(String s)
    {
        int l = 0, r = s.length()-1;
        while(l <= r)
        {
            if(s.charAt(l) == s.charAt(r))
            {
                l++;
                r--;
            }
            else
                return false;
        }
        return true;
    }
}

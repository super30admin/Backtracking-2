// Time Complexity : O(2^N) where N is lenght of input string.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class PalindromePartitioning {
    List<List<String>> result = new ArrayList();
    public List<List<String>> partition(String s)
    {
        helper(s, 0, new ArrayList());
        return result;
    }
    public void helper(String s, int partitionIdx, List<String> path)
    {
        if(partitionIdx >= s.length())
        {
            result.add(new ArrayList(path));
            return;
        }
        for(int i = partitionIdx; i < s.length(); i++)
        {
            String splitStr = s.substring(partitionIdx, i+1);
            if(isPalindrome(splitStr))
            {
                path.add(splitStr);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s)
    {
        int start = 0;
        int end = s.length()-1;
        while(start <= s.length()-1)
        {
            if(s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }
}

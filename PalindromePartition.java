class Solution {
    List<List<String>> result;
    int count;
    public List<List<String>> partition(String s) {
        result = new ArrayList();
        if ( s == null || s.length() == 0)
            return result;
        helper(s, 0, new ArrayList());
        System.out.println("count "+ count);
        return result;
    }
    private void helper(String s, int pivotIndex, List<String> path)
    {
        if ( pivotIndex == s.length())
        {
            result.add(new ArrayList(path));
            count++;
            return;
        }    
       for (int i = pivotIndex; i < s.length(); i++)
       {
           if (isPalindrome( s, pivotIndex, i))
           {
                 //action
                path.add(s.substring(pivotIndex, i+1));
                // recurse
                helper( s, i+1, path);
                 // backtrack
                path.remove(path.size()-1);
            }       
         }
    }
    private boolean isPalindrome(String str, int l, int r)
    {
        while ( l <= r)
        {
            if (str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}

class Solution {
    //Time O(N*2^N)
    //Space O(N)
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s , new ArrayList<>(), 0);
        return result;
    }
    private void helper(String s, List<String> path , int index)
    {
        //base
        if(index == s.length())
        {
            result.add(new ArrayList<>(path));
        }
        //logic
        for(int i=index ; i<s.length() ; i++)
        {
            if(isPalindrome(s.substring(index , i+1)))
            {
                path.add(s.substring(index, i+1)); // Action
                helper(s , path, i+1);       // Recurse
                path.remove(path.size()-1); //BackTrack
            }  
        }
    }
    private boolean isPalindrome(String s)
    {
        int i=0 , j=s.length()-1;
        while(i <= j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            i++;j--;
        }
        return true;
    }
}
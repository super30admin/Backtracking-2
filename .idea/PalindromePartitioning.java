class PalindromePartitioning {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0)
            return result;
        backtrack(s,0, new ArrayList());
        return result;

    }
    private void backtrack(String s, int index, List<String> path)
    {
        if(s.length()==index)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for(int i =index; i<s.length();i++)
        {
            if(isPalindrome(s, index,i))
            {
                path.add(s.substring(index,i+1));
                backtrack(s, i+1,path);
                path.remove(path.size()-1);
            }
        }

    }
    private boolean isPalindrome(String s, int l, int r)
    {
        if(l==r)
            return true;
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
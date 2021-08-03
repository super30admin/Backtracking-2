class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s)
    {

        helper(s,0,new ArrayList<>());
        return res;
    }

    private void helper(String s , int index , ArrayList<String> temp)
    {
        if(index == s.length())
        {
            res.add(new ArrayList<>(temp));
        }

        for(int i=index ; i<s.length() ; i++)
        {
            if(palindrome(s.substring(index,i+1)))
            {
                temp.add(s.substring(index,i+1));
                helper(s,i+1,temp);
                if(temp.size()>0) temp.remove(temp.size()-1);
            }

        }
    }

    private boolean palindrome(String s)
    {
        StringBuilder str = new StringBuilder(s);
        StringBuilder revstr = str.reverse();
        return(s.equals(revstr.toString()));
    }
}

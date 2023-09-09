class Solution {
    List<List<String>>res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return res;
    }
    public void helper(String s, int pivot, List<String>path)
    {
        if(pivot==s.length())
        {
            res.add(path);
            return;
        }
        for(int i=pivot;i<s.length();i++)
        {
            String subs = s.substring(pivot,i+1);

            if(isPalindrome(subs)){
                List<String>li = new ArrayList<>(path);
                li.add(subs);
                helper(s,i+1,li);

            }
        }
    }
    public boolean isPalindrome(String s)
    {
        int start=0;
        int end=s.length()-1;
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
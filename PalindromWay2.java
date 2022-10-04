class Solution {

    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null) return result;
        helper(s,new ArrayList<>());
        return result;
        
    }
    private void helper(String s,List<String> path)
    {
        //base case
        if(s.length() == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=0;i<s.length();i++)
        {
            String sub = s.substring(0,i+1);
             //last ele not counted
            if(isPalindrome(sub))
            {
            //action
            path.add(sub);
            //recurse   
            helper(s.substring(i+1),path);
                //backtrack
            path.remove(path.size()-1);  
            }
        }
    }
    private boolean isPalindrome(String s)
    {
        int start = 0;
        int end = s.length()-1;
        while(start<end)
        {
            if(s.charAt(start) != s.charAt(end))
                return false;
            else
            {
                start++;
                end--;
            }
        }
        return true;
    }
}
class Solution {

    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null) return result;
        helper(s,0,new ArrayList<>());
        return result;
        
    }
    private void helper(String s,int pivot,List<String> path)
    {
        //base case
        if(pivot == s.length())
        {
            result.add(path);
            return;
        }
        //logic
        for(int i=pivot;i<s.length();i++)
        {
            String sub = s.substring(pivot,i+1);
             //last ele not counted
            if(isPalindrome(sub))
            {
            List<String> temp = new ArrayList<>(path);
            temp.add(sub);
               
            helper(s,i+1,temp);
            }
        }
    }
    //backtrack
    private void helper(String s,int pivot,List<String> path)
    {
        //base case
        if(pivot == s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=pivot;i<s.length();i++)
        {
            String sub = s.substring(pivot,i+1);
             //last ele not counted
            if(isPalindrome(sub))
            {
            //action
            path.add(sub);
            //recurse   
            helper(s,i+1,path);
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
//TC : O(2^n)
//SC -O(n)
//Palindrome Partitioning
class Solution2 {
    List<List<String>> result;
    public List<List<String>> partition(String s) {

            result=new ArrayList<>();
            helper(s,0,new ArrayList<String>());
            return result;
    }
    private void helper(String s,int pivot,List<String> path)
    {
        //base 
         //we are adding result only when we reach tothe end of the string.. 
         if(pivot==s.length())
         {
             result.add(new ArrayList<>(path));
             return;
         }

        //for loop recursion 
        //logic

        for(int i=pivot;i<s.length();i++)
        {
            //get substring between pivot and i
            String sub=s.substring(pivot,i+1);
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
// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Problems while backtracking or during dry run on whiteboard

class SolutionTwo {

    List<List<String>> result;

    public List<List<String>> partition(String s) {

        if(s==null)
            return result;

        result=new ArrayList<>();

        helper(s,new ArrayList<>(),0);

        return result;
    }

    public void helper(String s,List<String> temp,int index)
    {
        //base
        if(index==s.length())
        {
            result.add(new ArrayList<>(temp));
            return;
        }


        //logic
        for(int i=index;i<s.length();i++)
        {
            if(isPalindrome(s,index,i))
            {
                //action
                temp.add(s.substring(index,i+1));

                //recurse
                helper(s,temp,i+1);

                //backtrack
                temp.remove(temp.size()-1);

            }
        }
    }

    public boolean isPalindrome(String s,int l,int r)
    {
        if(l==r)
            return true;

        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
                return false;

            l++;r--;
        }
        return true;
    }
}
//TC: O(n*2^n)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result=new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return result;
    }
    private boolean isPalindrome(String s)
    {
        int st=0;
        int e=s.length()-1;
        while(st<=e)
        {
            if(s.charAt(st)!=s.charAt(e))
            return false;
            st++;
            e--;
        }
        return true;
    }
    private void helper(String s, int pivot, List<String> path)
    {
      if(pivot==s.length())
      {
      result.add(new ArrayList<>(path));
      return;
      }

        for(int i=pivot;i<s.length();i++)
        {
            String curr=s.substring(pivot,i+1);
            if(isPalindrome(curr))
            {
                path.add((curr));
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }
}
// Runtime complexity -O(N*(2^N)) where N is the length of the string s.
// Space complexity - O(N) where N is the length of the string - the size of recursion stack.   

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        if(s==null || s.length()==0)
            return result;
        backtrack(s,0,new ArrayList<String>());
        return result;
    }
    
    public void backtrack(String s, int index, List<String> path)
    {
        // Base condition
        if(index>=s.length())
        {
            result.add(new ArrayList<String>(path));
            return;
        }
        
        // iteration
        for(int i=index;i<s.length();i++)
        {
            if(ispalendrome(s,index,i))
            {
                //add
                path.add(s.substring(index,i+1));
                //recurse
                backtrack(s,i+1,path);
                //remove/backtrack
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean ispalendrome(String s, int start,int end)
    {
        if(start==end)
            return true;
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

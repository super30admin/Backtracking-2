// Time Complexity :O(N^2)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result= new ArrayList<>();
        List<String> path= new ArrayList<>();
        helper(0,s,result,path);

        return result;
    }
    public void helper(int index,String s, List<List<String>> result,List<String> path)
    {
        if(index==s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++)
        {
            if(Palendromic(s,index,i))
            {
                path.add(s.substring(index,i+1));
                helper(i+1,s,result,path);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean Palendromic(String s,int start,int end)
    {
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
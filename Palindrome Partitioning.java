// Time complexity:O(2^n)
// SPace complexity:O(n)

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        
        if(s.length()==0) return result;
        
        helper(s, new ArrayList<>(), 0);
        return result;
        
    }
    private void helper(String s, List<String> path, int index)
    {
       //base
        if(index==s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i=index;i<s.length();i++)
        {
            //temp list
           
            if(isPalindrome(s,index,i))
            {
                //List<String> temp=new ArrayList<>(path);
                path.add(s.substring(index,i+1));
                helper(s,path,i+1);
                path.remove(path.size()-1);
            }
        }
        
}
    private boolean isPalindrome(String s, int l, int r)
    {
        if(l==r) return true;
        
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;r--;
        }
        
        return true;
    }
}

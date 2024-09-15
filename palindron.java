// time: O(n^n)
// space: O(n)
class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> partition(String s) {
        //if(s.length()=0) return list;
        List<String> list=new ArrayList<>();
        backtrack(s,0,list);
        return result;
    }
    public void backtrack(String s,int index,List<String> list)
    {
        if(index==s.length())
        {
            result.add(new ArrayList<>(list));
        }
        for(int i=index;i<s.length();i++)
        {
            if(isPalindrone(s,index,i))
            {
                list.add(s.substring(index,i+1));
                backtrack(s,i+1,list);
                //  baktrack
                list.remove(list.size()-1);
            }
        }
    }
    // function to check palindrone
    public boolean isPalindrone(String s,int l,int r)
    {
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
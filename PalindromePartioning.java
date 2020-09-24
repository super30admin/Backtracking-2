//Time Complexity=O(n^n)
//Space Complexity=O(n)
class Solution {
    List<List<String>>output=new ArrayList();
    public List<List<String>> partition(String s) {
        List<String>path=new ArrayList();
        backTrack(s,0,path);
        return output;
    }
    void backTrack(String s,int index,List<String>path)
    {
        if(index>=s.length())
        {
            output.add(new ArrayList(path));
        }
        for(int i=index;i<s.length();i++)
        {
            String temp=s.substring(index,i+1);
            if(isPalindrome(temp))
            {
                path.add(temp);
                backTrack(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }
    boolean isPalindrome(String s)
    {
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
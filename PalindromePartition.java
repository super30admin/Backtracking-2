/* Time Complexity :  O(n*2^n)
   Space Complexity :  O(n) where n is length of string
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        recurse(s,0,new ArrayList());
        return res;
    }
    private void recurse(String s, int index, List<String> path){
        //base
        if(index==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=index;i<s.length();i++){
            String temp = s.substring(index,i+1);
            if(findPalindrome(temp)){
            path.add(temp); //action
            recurse(s,i+1,path);
            path.remove(path.size()-1);
            }
        }
    }
    private boolean findPalindrome(String curStr){
            int start=0,end=curStr.length()-1;
            while(start<end){
                if(curStr.charAt(start)==curStr.charAt(end)){
                    start++;
                    end--;
                }
                else
                {
                    return false;
                }
            }
        return true;
    }
}
// Time Complexity : O(2 power n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach/**
for loop based recursionthrough out the string



class Solution {
     List<List<String>>result = new ArrayList<>();
    public List<List<String>> partition(String s) {
       
        helper(s,0,new ArrayList<>());
        return result;
    }
    private void helper(String s,int idx,List<String>path){
        //base
        if(idx == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        
        //logic
        for(int  i = idx;i<s.length();i++){
            String sub = s.substring(idx,i+1);
            if(ispalindrome(sub)){
                path.add(sub);
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean ispalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}
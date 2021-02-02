// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        if(s==null || s.length()==0) return result;
        helper(s,0,new ArrayList<>());
        return result;
    }
    
    private void helper(String s,int index,List<String> path){
        //base
        // if(index==s.length()){
        //     result.add(new ArrayList<>(path));
        //     return;
        // }
        
        if(s.length()==0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                //action
                path.add(s.substring(index,i+1));
                helper(s.substring(i+1),0,path);
                //helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s,int l,int r){
        if(l==r) return true;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l=l+1;
            r=r-1;
        }
        return true;
    }
}











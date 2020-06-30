// Time Complexity : O(2^n). n is the length of the string
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


class Solution {
    List<List<String>> list;
    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0) return new ArrayList();
        
         list = new ArrayList();
        backtrack(s,new ArrayList(),0);
        return list;   
    }
    
    private void backtrack(String s,List<String> li,int start){
        
        if(start>=s.length()){
            list.add(new ArrayList(li));
        }
        
        for(int i=start;i<s.length();i++){
            
            if(isPalindrome(s,start,i)){
                //action
                li.add(s.substring(start,i+1));
                
                //recursive
                backtrack(s,li,i+1);
                
                //backtrack
                li.remove(li.size()-1);
            }
        }
        
        
    }
    
    private boolean isPalindrome(String s,int start,int end){
        if(start==end)return true;
        
        while(start<end){
            
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;end--;
        }
        return true;
    }
}

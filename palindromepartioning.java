// Time Complexity : o() exponential 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    List<List<String>> r;
    public List<List<String>> partition(String s) {
        r= new ArrayList<>();
        
        h(s,0,new ArrayList<>());
        return r;
    }
    private void h(String s,int in,List<String> p){
        //base case
        if(in==s.length()){
            r.add(new ArrayList<>(p));
            return;
        }
        
        //logic
        
        for(int i=in;i<s.length();i++){
            if(k(s,in,i)){
      
                p.add(s.substring(in,i+1));
                h(s,i+1,p);
                p.remove(p.size()-1);
            }
        }
    }
    private boolean k(String s,int l,int r){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n*2^n)
// Space Complexity :O(n*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


public class pallindromPartitioning {
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
       result=new ArrayList<>();
        
        if(s==null || s.length()==0)
            return result;
        
        backtrack(s,0,new ArrayList<>());     
        
        return result;
    }
    
    private void backtrack(String s, int index, List<String> path){
        //base
        if(index==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i=index;i<s.length();i++){
            
            if(isPallindrom(s,index,i)){
                
                path.add(s.substring(index,i+1));
                backtrack(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
        
    }
    
    private boolean isPallindrom(String s, int l,int r){
        if(l==r)
            return true;
        
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
    return true;
        
    }
}

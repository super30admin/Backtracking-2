/*
Time Complexity: O(N*2^N)
Space Complexity: O(N)
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Solution {
	   boolean isPalindrome(String s) {
	       int low=0;
           int high=s.length()-1;
           while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
	    }   
	 void helper(String s,List<String> path,List<List<String>> res,int start){
         if(start==s.length()){
             res.add(new ArrayList<>(path));
             return;
         }
         
         //branching 
         for(int i=start;i<s.length();i++){
                String sub=s.substring(start,i+1);
             if(isPalindrome(sub)){
                 path.add(sub);
                 helper(s,path,res,i+1);
                 path.remove(path.size()-1);
             }
             
        
         }
     }
	public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<List<String>>();
        List<String> path=new ArrayList<String>();
        helper(s,path,res,0);
    return res;
    }
}
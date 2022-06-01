import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(N*2^N)
//Space Complexity : O(N)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
          result = new ArrayList<>();
          helper(s,0,new ArrayList<>());
          return result;
    }
    
    public void helper(String s, int pivot, List<String> path){
        //base
        if(pivot == s.length()){
            result.add(new ArrayList(path));
            return;
        }
        //logic
        for(int i = pivot; i < s.length(); i++){
            String sub = s.substring(pivot,i+1);
            //if substring is palindrome only then add to path
            if(isPalindrome(sub)){
                //action
                //add current substring in the current list
                path.add(sub);
                //recurse
                helper(s, i+1, path);
                //backtrack 
                //and remove the current substring from currentlist
                path.remove(path.size()-1);
            }
        }
    }
    //method to check whether the given string is palindrome
    public boolean isPalindrome(String s){
        int i = 0;int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

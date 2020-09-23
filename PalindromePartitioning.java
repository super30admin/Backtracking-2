//Time Complexity: O(n*n^n) n^n is of the recursive call and n is for iterating n times
//Space Complexity: O(1) 

import java.util.*;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> l = new ArrayList<>();
        if(s.length() == 0 || s == null)
            return l;
        List<String> path = new ArrayList<>();
        helper(s, 0, l, path);
        return l;
    }
    
    public void helper(String s, int index, List<List<String>> l, List<String> path){
        if(index >= s.length()){
            //if index is out of bound add it to output list
            l.add(new ArrayList<>(path));
            return;
        }
        for(int i= index; i<s.length(); i++){
            // getting the substring from index to i+1 i+1 will go increase the string size
            String sub = s.substring(index, i+1);
            //only recursing if the substring is pallindrome
            if(isPallindrome(sub)){
                // adding the substring to the current path
                path.add(sub);
                // now index the index and recurse
                helper(s, i+1, l, path);
                // backtracking to the previous
                path.remove(path.size()-1);
            }
        }
    }
    // pallindrome check using 2 pointer approach
    public boolean isPallindrome(String str){
        int l = 0;
        int r = str.length() - 1;
        while(l <= r){
            if(str.charAt(l) == str.charAt(r))
            {
                l++;
                r--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
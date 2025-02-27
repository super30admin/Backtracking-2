//The approach here is to check all possible substrings using for-loop based recursion
//At each substring split, we check if each of the current partition is palindrome or not, only then, we proceed for the recursion.
//When we reach the leaf nodes, then we make the deep copy of the path and add it to the result
//Time Complexity: O(n*2^n), where n is the length of the string
//Space Complexity: O(n)
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        if(s==null || s.length() == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path){
        //base
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i = pivot; i<s.length(); i++){
            String currPart = s.substring(pivot, i+1); //i+1 because exludes the last index from substring
            if(isPalindrome(currPart, 0, currPart.length()-1)){
                //action
                path.add(currPart);
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
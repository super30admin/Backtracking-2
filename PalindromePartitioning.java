// Time Complexity : O(n*2 pow n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

//recursively go through the length of the string with backtracking to find all the possible palindrome substrings
import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s,0, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int st, List<String> temp){
        //base case

        //logic
        for(int i=st; i< s.length(); i++ ){
            if(isPalindrome(s,st,i)){
                temp.add(s.substring(st,i+1));
                backtrack(s,i+1, temp);
                temp.remove(temp.size() -1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }

}
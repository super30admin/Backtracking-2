package Backtracking_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Using for loop based recursion to create all the possible combinations out of
 * the word and while processing we only recurse further if current substring is
 * a palindrome.
 * 
 * Time Complexity : O(n*2^(n))- where n is the length of the string given.
 * 
 * Space Complexity : O(n), actually is the height of the tree in worst
 * case(space needed for recursive stack)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
    List<List<String>> result= new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s,new ArrayList<>());
        return result;
    }

    void helper(String s,List<String> path){
        //base
        if(s.length()==0){
            result.add(new ArrayList<>(path));
        }
        //logic
        for(int i=0;i<s.length();i++){
           if(isPalindrome(s.substring(0,i+1))) {
            path.add(s.substring(0,i+1));
            helper(s.substring(i+1,s.length()), path);
            path.remove(path.size()-1);}
        }
    }

    boolean isPalindrome(String s){
        int l=0;
        int h=s.length()-1;

        while(l<s.length()){
            if(s.charAt(l)!=s.charAt(h))
                return false;
            
            l++;
            h--;
        }
        return true;
    }

}

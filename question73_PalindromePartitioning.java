package Backtracking2;

import java.util.ArrayList;
import java.util.List;

public class question73_PalindromePartitioning {
    /* Created by palak on 7/1/2021 */

    /*
    Backtracking:
        Time Complexity: O(n * 2^n)
        Space Complexity: O(n)
    */
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        backtrack(s, new ArrayList<>());
        return result;
    }
    private void backtrack(String s, List<String> path) {
        //Base
        if(s.length() == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        //Logic
        for(int i = 0 ; i < s.length() ; i++) {
            if(isPalindrome(s, 0, i)) {
                List<String> copy = new ArrayList<>();
                //action
                path.add(s.substring(0, i + 1));
                //recurse
                backtrack(s.substring(i + 1), path);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }


    /*
    Recursion
        Time Complexity: O(n * 2^n)
        Space Complexity: O(n)
    */
    List<List<String>> result2;
    public List<List<String>> partition2(String s) {
        result2 = new ArrayList<>();
        if(s == null || s.length() == 0) return result2;
        backtrack2(s, new ArrayList<>());
        return result2;
    }
    private void backtrack2(String s, List<String> path) {
        //Base
        if(s.length() == 0) {
            result2.add(path);
            return;
        }
        //Logic
        for(int i = 0 ; i < s.length() ; i++) {
            if(isPalindrome2(s, 0, i)) {
                List<String> copy = new ArrayList<>(path);
                //action
                copy.add(s.substring(0, i + 1));
                //recurse
                backtrack2(s.substring(i + 1), copy);
                //backtrack
                // path.remove(path.size() - 1);
            }
        }
    }
    private boolean isPalindrome2(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
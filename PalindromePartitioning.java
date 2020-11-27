/*
Author: Akhilesh Borgaonkar
Problem: Return all possible palindrome partitioning of s.
Approach: Used Backtracking here. Start with initial character in the inp[ut string and combine it with all other possibilities extensively.
    I make choices of substring then check if they are pallindrome. If yes then, add it to result list else continue with next substring.
Time complexity: O(2^n) where n is the length of input string.
Space complexity: O(n)
Issues faced: Initially, I faced issue with understanding the choices that I need to make. But, after the class I figured it out.
*/

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s.length()==0) return result;
        backtrack(s, result, new ArrayList<String>());
        return result;
    }

    private static void backtrack(String s, List<List<String>> result, List<String> temp ){

        //base condition
        if(s.length()==0) {
            result.add(new ArrayList<String>(temp));
            return;
        }
        //recursive call
        for(int i=0; i<s.length(); i++){
            if(isPalin(s.substring(0,i+1))){
                temp.add(s.substring(0,i+1));
                backtrack(s.substring(i+1), result, temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static boolean isPalin(String s){
        return s.equals(new StringBuilder(s).reverse().toString());
    }

}


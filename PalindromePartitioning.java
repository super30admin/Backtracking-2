package com.ds.rani.backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
//Approach: find out all the combinations and add those combinations who meet the criteria
//Time complexity:n*(2^n)
//Space complexity:o(n) as we are maintaning only single list
public class PalindromePartitioning {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        backtrack( s, new ArrayList<>(), 0 );
        return result;
    }

    private void backtrack(String s, List<String> currList, int currIndex) {

        //base case
        if (currIndex == s.length()) {
            result.add( new ArrayList<>( currList ) );
        }

        for (int i = currIndex; i < s.length(); i++) {

            if (isPlaindrome( s, currIndex, i )) {
                //action
                currList.add( s.substring( currIndex, i + 1 ) );
                //recurse
                backtrack( s, currList, i + 1 );

                //backtrack
                currList.remove( currList.size() - 1 );
            }


        }
    }

    private boolean isPlaindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt( start ) != str.charAt( end ))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

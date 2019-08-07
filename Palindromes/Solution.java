/**
 * Time Complexity : O(m * 2^n) - m is for palindrome check
 * Space Complexity: O(1) - stack space 
 * Leetcode - Yes
 */

import java.util.*;
class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int position = 0;
        helper(result, new ArrayList<>(), s, position);
        return result;
    }

    public void helper(List<List<String>> result, List<String> tempList, String s, int position){
        if(position == s.length()){
            result.add(new ArrayList<>(tempList));
        }
        else {
            for(int i=position;i<s.length();i++){
                if(isPalindrome(s, position, i)){
                    tempList.add(s.substring(position, i+1));
                    helper(result, tempList, s, i+1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end))    return false;
            start++;end--;
        }

        return true;
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("PalindromePartition");
        PalindromePartition obj = new PalindromePartition();
        System.out.println(obj.partition("aab"));
    }
}
// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * 1. At each index, either we choose or not choose. If we choose, we move the pivot and index to index+1.
 * 2. If we dont choose, we stay at the same pivot and move the index to index+1.
 * 3. If index is out of bounds we check for the length of the string in current list and if it is equal to the length of the string, we add it to the result.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, 0, new ArrayList<>(), result, 0);
        return result;
    }

    private void helper(String s, int pivot, int index, List<String> substr, List<List<String>> result, int sum){
        if(index == s.length()){
            if(sum == s.length()){
                result.add(new ArrayList<>(substr));
            }
            return;
        }

        helper(s, pivot, index+1, substr, result, sum);

        String str = s.substring(pivot, index+1);
        if(isPalindrome(str)){
            substr.add(str);
            helper(s, index+1, index+1, substr, result, sum + str.length());
            substr.remove(substr.size()-1);
        }
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length()-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
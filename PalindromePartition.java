/*
Time Complexity : O(L.2^L). L is the length of the input string
Space Complexity : O(L), L characters in the recursion stack
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
Approach :

We need to partition the string, we can do that by creating substring between 2 indices(pivot and index).
We need to check if all the substrings is valid palindrome, if yes, add the substrings to a result array.

*/
import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partitionRecursion(s, result, new ArrayList<>(), 0);
        return result;
    }

    private void partitionRecursion(String s, List<List<String>> result, List<String> path, int pivot) {
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < s.length(); i++) {
            String subString = s.substring(pivot, i+1);
            if(isPalindrome(subString)){
                path.add(subString);
                partitionRecursion(s, result, path, i+1);
                // backtrack
                path.remove(path.size()-1);
            }
        }
    }

    boolean isPalindrome(String s){
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if(s.charAt(i) != s.charAt(len-1-i)) return false;
        }
        return true;
    }
}

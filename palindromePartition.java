// Time Complexity : Add : O(n * 2^(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        partition(s);
    }

    static List<List<String>> result;
    public static List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length()==0)
            return result;

        helper(s, 0, new ArrayList<>());

        return result;
    }

    private static void helper(String s, int index, List<String> path){ // S.C - O(n)
        //base
        if(index == s.length())
            result.add(new ArrayList<>(path));

        //logic
        for(int i=index; i<s.length(); i++){
            String sub = s.substring(index, i+1); // T.C - O(n * 2^n)
            if(isPalindrome(sub)){
                path.add(sub);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String sub){
        int low = 0;
        int high = sub.length()-1;
        while(low<high){
            if(sub.charAt(low) != sub.charAt(high))
                return false;

            low++;
            high--;
        }
        return true;
    }
}


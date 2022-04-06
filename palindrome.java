/*
Time Complexity : O(2 ^N) where n is the length of the string.
Space Complexity :  O(n) here n is the number of elements in the recursive stack.

*/

import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        helper(s, new ArrayList<>(), result);

        return result;
    }

    private void helper(String s, List<String> currList, List<List<String>> result) {

        if (s.isEmpty()) {

            result.add(currList);
        }
        for (int i = 1; i <= s.length(); i++) {

            String left = s.substring(0, i);
            String right = s.substring(i);

            if (palindrome(left)) {

                List<String> list = new ArrayList(currList);
                list.add(left);

                helper(right, list, result);
            }
        }

    }

    private boolean palindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {

            if (s.charAt(i) != s.charAt(j)) {

                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
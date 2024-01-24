/*
* Approach:
*  1. Explore the possibilites by for loop based recursion using pivot.
* 
*  2. Iterate from pivot to length of string,
        take substring from pivot to index and check if its palindrome.
        if yes,
            add to partition and recurse on index+1.
            backtrack by removing last substring added
* 
*  3. When index reaches end of string, 
        add partition to result
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n * 2^n)
    n = length of string
* 
* Space Complexity: O(2^n)
* 
*/

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningForLoopbased {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();

        helper(s, 0, new ArrayList<>());

        return result;
    }

    private void helper(String s, int pivot, List<String> partition) {
        if (pivot == s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int index = pivot; index < s.length(); index++) {
            String substr = s.substring(pivot, index + 1);

            if (isPalindrome(substr)) {
                partition.add(substr);
                helper(s, index + 1, partition);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

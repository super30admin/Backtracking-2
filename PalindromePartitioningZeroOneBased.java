/*
* Approach:
*  1. Explore exhaustively by choose, not choose.
        To do this, 
            we need to keep track of start of substring and end of substring,
            so we maintain two variables, pivot and index.

        "count" is used to keep track of valid partitioning size,
        because partition should include all elements in main string.
* 
*  2. not choose case:
            move index to next position and recurse
        choose case:
            take substring from pivot to index
            check substring is palindrome or not.
            if yes,
                add to partition and increment count value by pal length
                recurse with pivot and index updated to index+1.
            backtrack once recurse step is completed.
* 
*  3. When index reaches end of string, 
        check the count(length of valid partition elements) with s.length
            if equal, add partition to result
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

public class PalindromePartitioningZeroOneBased {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();

        helper(s, 0, 0, new ArrayList<>(), 0);

        return result;
    }

    private void helper(String s, int pivot,int index, List<String> partition, int count) {
        if (index == s.length()) {
            if(count == s.length()){
                result.add(new ArrayList<>(partition));
            }
            return;
        }

        //not choose
        helper(s, pivot, index+1, partition, count);

        // choose
        String substr = s.substring(pivot, index+1);

        if(isPalindrome(substr)){
            partition.add(substr);
            count += substr.length();

            // move pivot and index to index+1
            helper(s, index+1, index+1, partition, count);

            partition.remove(partition.size()-1);
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
/*
Approach : 
This is a backtracking solution for palindrome partitioning.

You explore the string using two indices, pivot and i.

pivot represents the start of the current substring.
i represents the current expanding end.

Idea is to generate all possible partitions and validate palindrome condition during recursion.
 */

// Time : O(nx2^n)
// Space: O(n)


class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, 0, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, int i, int size, List<String> path) {

        if(i == s.length()) {
            if(size == s.length()){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        // no choose case
        helper(s, pivot, i+1, size, path);

        // choose case
        String subStr = s. substring(pivot, i+1);
        if(isPalindrome(subStr)){
            // action
            path.add(subStr);
            // recurse
            helper(s, i+1, i+1, size+subStr.length(), path);
            // backtrack
            path.remove(path.size()-1);

        }
    }

    private boolean isPalindrome(String s){ // check whether string is palindrome or not
        int left = 0, right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
                left ++; right--;
        }

        return true;
    }
}
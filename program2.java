// Time Complexity : O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :yes

/*
 * Approach
 * here are we using recursion to solve the problem,
 * basically at each step we have to choose between pick or not pick a number
 * for this we are using recurion
 * 
 * we are going to use the for loop based recursion 
 * in each recursive call we start a new for loop from pivot till s len
 * create a new sub string from pivot to i+1
 * do the palindrome check on the string if true
 * add to path make the recursive call again with i+1
 * finally backtrack to keep the path update for the cur level
 * 
 * 
 * for the palindrome check
 * we simply 
 * loop from both ends of the string to see if the are equal of not
 * 
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(String s, int pivot, List<String> path, List<List<String>> result) {
        // base
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for (int i = pivot; i < s.length(); i++) {

            String cur = s.substring(pivot, i + 1);
            if (isPalindrome(cur)) {
                // add
                path.add(cur);

                // recurse
                helper(s, i + 1, path, result);

                // backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
// Time Complexity : N*2^N - two choices for n elements and in worst case scenarion all elements are part of palindrome string
// Space Complexity : N - len of the string, recurssive stack will be of length N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class PalindromePartition {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0)
            return result;
        helper(s, new ArrayList<>());
        return result;
    }

    private void helper(String s, List<String> list) {
        // base case
        if(s == null || s.length() == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            // do backtracking only if current string is palindrome
            if(!isPalindrome(temp)) continue;

            list.add(temp);  // choose
            helper(s.substring(i, s.length()), list); // explore
            list.remove(list.size() - 1); // unchoose
        }

        return;
    }

    //check if string is palindrome
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }

        return true;
    }
}
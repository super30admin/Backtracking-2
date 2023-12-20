// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * For loop based recursion backtracking with passing substring instead of index
 */
class Solution {

    List<List<String>> result;
    List<String> path;

    public List<List<String>> partition(String s) {

        this.result = new ArrayList<>();
        this.path = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot) {

        //base
        if(pivot == s.length())
            result.add(new ArrayList<>(path));
        //logic

        for(int i=pivot; i<s.length(); i++) {

            String sub = s.substring(pivot, i+1);

            if(isPalindrome(sub)) {
                //action
                path.add(sub);
                //recurse
                helper(s, i+1);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {

        int start = 0, end = s.length()-1;

        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }
}

/**
 * For loop based recursion backtracking
 */
/*
class Solution {

    List<List<String>> result;
    List<String> path;

    public List<List<String>> partition(String s) {

        this.result = new ArrayList<>();
        this.path = new ArrayList<>();
        helper(s);
        return result;
    }

    private void helper(String s) {

        //base
        if(s.length() == 0)
            result.add(new ArrayList<>(path));
        //logic

        for(int i=0; i<s.length(); i++) {

            String sub = s.substring(0, i+1);

            if(isPalindrome(sub)) {
                //action
                path.add(sub);
                //recurse
                helper(s.substring(i+1)); //s.substring(startIndex)
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {

        int start = 0, end = s.length()-1;

        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }
}*/


/**
 * 01 recursion backtracking
 */
/*class Solution {

    List<List<String>> result;
    List<String> path;

    public List<List<String>> partition(String s) {

        this.result = new ArrayList<>();
        this.path = new ArrayList<>();
        helper(s, 0, 0, 0);
        return result;
    }

    private void helper(String s, int pivot, int i, int sum) {

        //base
        if(i == s.length()) {
            if(sum == s.length())
                result.add(new ArrayList<>(path));
            return;
        }

        //logic
        //don't choose
        helper(s, pivot, i+1, sum);

        //choose
        String sub = s.substring(pivot, i+1);

        if(isPalindrome(sub)) {
            //action
            path.add(sub);
            //recurse
            helper(s, i+1, i+1, sum+sub.length());
            //backtrack
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s) {

        int start = 0, end = s.length()-1;

        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }
}*/

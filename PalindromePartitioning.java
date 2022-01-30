// Time Complexity : O(n * 2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 1 - for loop recursion no backtracking
class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return res;
    }

    private void helper(String s, int index, List<String> path) {
        if(index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i+1);
            if(isPalindrome(sub)) {
                List<String> temp = new ArrayList<>(path);
                temp.add(sub);
                helper(s, i+1, temp);
            }

        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}


// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 2 - for loop recursion with backtracking
class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return res;
    }

    private void helper(String s, int index, List<String> path) {
        if(index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i+1);
            if(isPalindrome(sub)) {

                path.add(sub);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }

        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
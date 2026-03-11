// Time Complexity : O(n * (2 ^ n))
// Space Complexity : O(n ^ 2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We use a for loop based recursion approach where we follow the steps of taking action, recurse and backtrack.
However, the question asks for palindrome partitions. So, we make partitions(by taking substring of pivot and i)
 recursively at each i and only want to explore/recurse it further if the substring(first part of partition)
 is a palindrome.This way, we prune the invalid paths.We iteratively recurse until our pivot goes out of
 bounds and then we add it to our result set.
 */
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path) {
        if(pivot == s.length())
            result.add(new ArrayList<>(path));
        for(int i = pivot ; i < s.length() ; i++) {
            String subStr = s.substring(pivot, i + 1);
            if(isPalindrome(subStr)) {
                path.add(subStr);
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0 , right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
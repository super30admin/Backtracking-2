// Approach 1 - For loop Recursion
// Time Complexity : O(n*(2^n))
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We can use recursion and keep track of pivot, current Index, current path
// we need pivot because we will take substring from pivot to curIdx
// we recurse and update curIdx, pivot and curPath only if substring is a palindrome

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, 0, new ArrayList<>());
        return result;
    }
    private void helper(String s, int partition, int idx, List<String> path){
        if(idx==s.length())
        {
            if(partition==s.length()){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=idx;i<s.length();i++){
            String substr = s.substring(partition, i+1);
            if(isPalindrome(substr)){
                path.add(substr);
                helper(s, i+1, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

// Approach 1 - 0/1 Recursion
// Time Complexity : O(n*(2^n))
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Similar to Approach 1
// for not choose condition, we do not partition at idx, and we update idx value
// for choose condition, we partition at idx and update path, current index, partition index

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, 0, new ArrayList<>());
        return result;
    }
    private void helper(String s, int partition, int idx, List<String> path){
        if(idx==s.length())
        {
            if(partition==s.length()){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        helper(s, partition, idx+1, path);
        String substr = s.substring(partition, idx+1);
        if(isPalindrome(substr)){
            path.add(substr);
            helper(s, idx+1, idx+1, path);
            path.remove(path.size()-1);
        }
    }
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}


// Time Complexity : n2^n => as we go over the n elements
// Space Complexity : O(n) due to recursive stack space where n is the length of string s
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Used 0-1 recursive approach by passing index & path to the recusrive function. In the base condition checked if index becomes equal to length of string then add path to result. Start with for loop from i = index the check if is it palindrome as only then we will initiate another recursive call. In palindrom pass index & i, if it is palindrome the start another recusrive call by passing index as i +1. In this method we create a new list, copy the existing path and then add s.substring(index, i +1) and pass this new list to recusrive method
 */
class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {

        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();

        recurse(s, 0, new ArrayList<>());

        return result;
    }

    private void recurse(String s, int index, List<String> path){

        //base
        if(index == s.length()){
            result.add(path);
        }

        //logic
        for(int i = index; i < s.length(); i ++){
            if(isPalindrome(s, index, i)){
                List<String> newList = new ArrayList<>(path);
                newList.add(s.substring(index, i +1));

                recurse(s, i + 1, newList);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
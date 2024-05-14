// Time Complexity : O(n * 2^n)
// Space Complexity : O(n * 2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>(); //Initialize the result list of lists
        helper(s, 0, new ArrayList<>()); //Recursion call
        return result; //Return result
    }

    public void helper(String s, int pivot, List<String> path) {
        // base
        if (pivot == s.length()) { //If the pivot reaches the end of the string
            result.add(new ArrayList<>(path)); //You can add that path to the result list as a new path list and copying the elements to the newly created list
            return;
        }

        // logic
        for (int i = pivot; i < s.length(); i++) {
            String substr = s.substring(pivot, i + 1); //Extracts the sub string between pivot and i+1 +1 because it takes one more
            if (isPalindrome(substr)) {
                path.add(substr); //If it is a palindrome, add that substring to the path
                helper(s, i + 1, path); //Calls recursive function with i+1 as we extract the substring between pivot and i
                path.remove(path.size() - 1); //Backtrack to explore other combination of the remaining substring
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (end > start) {
            if (s.charAt(start) != s.charAt(end)) { //Checks the first and the last element
                return false;
            } else {
                end--;
                start++;
            }
        }
        return true;
    }
}
// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Write a check palindrome funtion that would return false if string is not palindrome, true otherwise
// Create a partition function which would partition the string into substring and check if its palindrome
// If the substring is palindrome we will call the partion method recursively
// When index length becomes equal to length of the string we can add that list of parts to the answer list
class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        partition(s, 0, new ArrayList());
        return ans;
    }
    private void partition(String s, int index, List<String> part){
        //base
        if(index == s.length()){
            ans.add(new ArrayList<>(part));
        }
        //recurse
        for(int i = index; i < s.length(); i++){
            String substr = s.substring(index, i+1);
            if(isPalindrome(substr)){
                part.add(substr);
                partition(s, i + 1, part);
                part.remove(part.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int start = 0, end = s.length()-1;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
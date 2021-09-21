// Time Complexity: O(n*2^n) as we are checking all possibloe combinations of each element for each index
// Space Complexity: recursive stack O(n) space complexity is used
// Did you complete it on leetcode: Yes
// Any problems faced: Came up with logic, A little help requiredfor implementation

// Write your approach:
// Idea here is to perform recursion and backtracking to check for each index
// in what ways the rest of the string is a palindrome,
// if whole string is not palidrome we continue to break the string
// into smaller substring, if a substring with successful palindrome condition is acquired
// we add it to list and continue to break for other combinations
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s==null) return new ArrayList<>();
        helper(s, 0, new ArrayList<String>());
        return result;
    }
    
    public void helper(String s, int index, List<String> li) {
        // base
        if(index>=s.length()) result.add(new ArrayList<String>(li));
        
        // logic
        for(int i=index; i<s.length(); i++) {
            if(isPalindrome(index, i, s)){
                li.add(s.substring(index, i+1));
                helper(s, i+1, li);
                li.remove(li.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(int start, int end, String s) {
        while(start<end) {
            if(s.charAt(start)==s.charAt(end)) {
                start++; end--;
            }
            else {
                return false;
            }
        }
        return true;
    }
    
}
/* Time Complexity : 
Recursive: O(n^n * 2^n) where n is the number of characters in the string. n copies of temporary list to result at each recursion + Palindrome check for each of n characters
Backtracking: O(n^n * 2^n) where n is the number of characters in the string, n copies of temporary list to result at each recursion + Palindrome check for each of n characters
Space Complexity : 
Recursive: O(n * 2^n) where n is the number of characters in the string. n copies of temporary list to result at each recursion + Palindrome check for each of n characters
Backtracking: O(n), maintaining a single temp list of palindromes througout for storing the subsets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach:  We have two decisions: choosing a character for string or not choosing the same.
Regardless on if we are choosing the character or not choosing, we move to the next index to choose the next one. As we are reaching the end of the
list, we check if the substring is a palindrome or not, if it is, we move to the next index to check again on valid palindrome. If we get each of the
character in the string along with the substrings of strings that are palindrome and are together making up the whole string, we add the list to the
result. */

// RECURSION
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
    result = new ArrayList<List<String>>();
    if(s == null || s.length() == 0){return result;}
    helper(s, 0, new ArrayList<String>());                                              // Start the recursion
    return result;
    }
    private void helper(String s, int index, List<String> temp){
        if(index == s.length()){                                                        // End of the string length, add the palindrome list
            result.add(temp);
            return;
        }
        for(int i = index; i < s.length(); i++){  
        if(isPalindrome(s, index, i)){                                                  // Check if it is a palindrome from index position to ith position
            List<String> newList = new ArrayList<>(temp);
            newList.add(s.substring(index, i+1));                                       // Add the palindrome substring to the temp list and check for the next ith position from index
            helper(s, i+1, newList);
        }
        }
    }
    private boolean isPalindrome(String sub, int i, int j){                                     // Standard palindrome check
        if(i==j){return true;}  
        while(i < j){
            if(sub.charAt(i) != sub.charAt(j)){return false;}                       // violation of palindrome, unequal strings
            i++;
            j--;
        }
        return true;
    }
}

// BACKTRACKING
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
    result = new ArrayList<List<String>>();
    if(s == null || s.length() == 0){return result;}                                    // Base Case
    backtrack(s, 0, new ArrayList<String>());                                               // Start the recursion
    return result;
    }
    private void backtrack(String s, int index, List<String> temp){
        if(index == s.length()){                                                        // index has marked end of the string
            result.add(new ArrayList<>(temp));                                          // Add the temp list copy to the result (not reference)
            return;
        }
        for(int i = index; i < s.length(); i++){  
        if(isPalindrome(s, index, i)){                                                          // check if it is a palindrome from index to ith position
            temp.add(s.substring(index, i+1)); 
            backtrack(s, i+1, temp);                                                            // check if the next index is also a part of palindrome starting from index position
            temp.remove(temp.size()-1);                                                 // Remove the last substring, undoing our action of adding a substring
        }
        }
    }
    private boolean isPalindrome(String sub, int i, int j){                                     // Standard Palindrome check
        if(i==j){return true;}
        while(i < j){
            if(sub.charAt(i) != sub.charAt(j)){return false;}                           // Palindrome violation
            i++;
            j--;
        }
        return true;                                                                    // Yes it is palindrome
    }
}
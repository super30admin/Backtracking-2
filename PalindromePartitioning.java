/*
Time: O(N*2^N) Space: O(2^N)
Algorithm:
=========
1. Generate partitions using backtracking, recursing from left to right (0 to s.length()-1)
2. Check if substring is palindrome, if it is, then recurse for palindrome partitioning on the remaining part
*/
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) return result;
        backtrack(s, new ArrayList<String>(), 0);
        return result;
    }
    
    private void backtrack(String s, List<String> temp, int index) {
        if(index == s.length()) {
            result.add(new ArrayList<>(temp));  // iterated through entire string, so add palindrome list to result
            return;
        }
        
        for(int i = index; i < s.length(); i++) { // iterate from index to end of string
            String sub = s.substring(index, i+1);   //get substring 
            if(isPalindrome(s, index, i)) { //check if it is palindrome
                temp.add(sub);              // add substring to temp
                backtrack(s, temp, i+1);    // recurse 
                temp.remove(temp.size()-1); // remove substring from temp
            }
        }
    }
    //check if string is palindrome for every substring
    private boolean isPalindrome(String s, int left, int right) {
        if(s == null || s.length() <= 1) return true;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
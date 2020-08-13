/**
Problem : Palindrome Partition
Did it run on LeetCode: Yes

Time Complexity : O(2^n) where n is the length of the string
Space Complexity : O(2^n) where n is the length of the string

Approach : Backtracking
1.We use  a 3-pronged approach. First, we perform an action, then we recurse, and if the condition is not met, we then backtrack(i.e, removing the previously performed action)
2. If a given substring is a palindrome, add it to the temporary list, and call the palindrome partitioning function recursively
3. When the entire string is traversed, we add the palindromic substrings to the result.
*/
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        backTrackTraverse(s, new ArrayList<>(), 0);
        return result;
    }
    public void backTrackTraverse(String s, List<String> temp, int start) {
        if(start >= s.length()) {
            result.add(new ArrayList<>(temp));
        }
        for(int i = start; i < s.length(); i++) {
            
            if(isPalindrome(s, start, i)) {
                //action
                temp.add(s.substring(start, i+1));
                //recurse
                backTrackTraverse(s, temp, i + 1);
            //backtrack
                temp.remove(temp.size()-1);
            }
            
        }
    }
    
    public boolean isPalindrome(String s, int l, int r) {
        if( l == r) return true;
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
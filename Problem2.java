// Link: https://leetcode.com/problems/palindrome-partitioning/
// Time Complexity: O(N 2 ^ N) N: Length of string
// Space Complexity: O(2 ^ N)

class Solution {
    
    List<List<String>> result;
    
    public boolean isPalindrome(String str) {
        
        if (str.length() == 1)
            return true;
        
        int left = 0, right = str.length() - 1;
        
        while(left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    
    public void helper(String s, int index, List<String> output) {
        
        if (index == s.length()) {
            result.add(new ArrayList<String>(output));
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            
            String curr = s.substring(index, i + 1);
            
            if (!isPalindrome(curr)) {
                continue;
            }
            
            output.add(curr);
            helper(s, i + 1, output);
            output.remove(output.size() - 1);
        }
    }
    public List<List<String>> partition(String s) {
        
        result = new ArrayList<>();
        
        if (s.length() == 0)
            return result;
        
        helper(s, 0, new ArrayList<String>());
        return result;
    }
}
// Time Complexity : O(n*2^n) where n is the length of the string s
// Space Complexity : O(2^n) where n is the length of the string s
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Backtracking

class palindromePartitioning {
    
    List<List<String>> ans = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        if (s.length() == 0) return ans;
        backtrack(s, new ArrayList<>(), 0);
        return ans;
    }
    
    private void backtrack(String s, List<String> list, int index) {
        // base case
        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // logic
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                backtrack(s, list, index + 1);  
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
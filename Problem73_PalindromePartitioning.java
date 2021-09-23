import java.util.*;
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<String>());
        return result;
    }
    
    private void helper(String s, int index, List<String> path) {
        // base case
        if(index >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                helper(s, i + 1, path);   
                // backtrack
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
// Time complexity: O(N*2^N) as it is exponential. There are 2^N number of nodes and at each node, we need to check if it is palindrome or not which take N time

// Space complexity: O(N) for the recursion stack

// Approach: for loop based recursion. We take substring from pivot to i and check if it is palindrome, we add it to our path, otherwise we don't continue recursion

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        backtrackHelper(s, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrackHelper(String s, int start, List<String> path) {
        // base
        if (start == s.length()) { // goal
            result.add(new ArrayList<>(path));
            return;
        }
        
        // logic
        for (int i = start; i < s.length(); i++) {
            String currSubstring = s.substring(start, i+1);
            if (isPalindrome(currSubstring)) { // constraint
                // action/choice
                path.add(currSubstring);
                
                //recurse
                backtrackHelper(s, i+1, path);
                
                // backtrack
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int i = 0; int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
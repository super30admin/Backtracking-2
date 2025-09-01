// Did not face any problem while running code
// TC: TC: O(2^n * n^2)
// SC: O(n)

class Solution {
    // Have a result set
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());  
        return result; 
    }
    // helper function to form all palindrome sets
    public void helper(String s, int pivot, List<String>  path) {
        // If Pivot reaches end, add to result
        if(pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Start from pivot until string length
        for(int i = pivot; i < s.length(); i++) {
            // Form a substring from pivout to 1 and check if its palindrome
            String st = s.substring(pivot, i+1);
            if(isPalindrome(st)){
                // Once substring is palindrome add to path and continue to iterate
                path.add(st);
                helper(s, i+1, path);
                // backtrack
                path.remove(path.size()-1);
            } 
        }
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
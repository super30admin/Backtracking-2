// Time Complexity: O(n * 2^n)
// Space Complexity: O(n)
// Ran on Leetcode succefully: yes
class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        // start from pivot = 0
        helperPartition(s, 0, new ArrayList<>());
        return ans;
    }

    public void helperPartition(String s, int pivot, List<String> curr) {
        // if pivot manages to reach the end then the curr is valid
        if (pivot == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for ( int i = pivot; i < s.length(); i++) {
            // before adding substring check if it is palindrome;
            if(isPalindrome(s.substring(pivot, i + 1))) {
                curr.add(s.substring(pivot, i + 1));
                helperPartition(s, i + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
    // Check if a string is palindrome
    public boolean isPalindrome(String s) {
        int L = 0;
        int R = s.length() - 1;
        // if left and right meet without violating the condition then its a palindrome
        while (L < R) {
            if(s.charAt(L++) != s.charAt(R--)) {
                return false;
            }
        }
        return true;

    }
}
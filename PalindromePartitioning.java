// Time complexity - O(2^n)
// Space complexity - O(n)
// Solved on leetcode - yes 
// Faced any issues - no
// The algorithm uses backtracking to explore all possible ways to partition the string such that every substring in the partition is a palindrome. At each index, it checks all possible substrings starting from that index, and if a substring is a palindrome, it adds it to the path and recursively continues from the next index. Once the end of the string is reached, the current valid path is added to the result list.
class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s,0, new ArrayList<>());
        return result;
    }

    public void helper(String s, int idx, List<String> path) {
        if (idx == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1); 
            if (isPalindrome(sub)) {
                path.add(sub);                    
                helper(s, i + 1, path);            
                path.remove(path.size() - 1);      
            }
        }
    }

    public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
}

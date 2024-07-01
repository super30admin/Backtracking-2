/*
    LC - 131. Palindrome Partitioning
    TC - O(n * 2 ^ n)
        In the worst case, we have 2^n possible ways to partition the string. This happens when all possible substrings are palindromes (e.g., for a string of all same characters).
        eg. "aaaa"
    SC - O(n) + O(n) ~ O(n)
        Result List: While the result list will ultimately contain up to 2^n partitions, we typically don't count the output space in auxiliary space complexity.
    Approach - using backtrack approach.
*/

class Solution {
    List<List<String>> result;
    List<String> path;
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtrack(s, 0);
        return result;
    }
    public void backtrack(String s, int index) {
        // base
        if(s.length() == index) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        for(int i=index; i<s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                String str = s.substring(index, i+1);
                path.add(str);
                backtrack(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String str, int start, int end) {
        while(start <= end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
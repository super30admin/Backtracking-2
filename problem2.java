// Time Complexity : O(2^n * n) 2^n partitions and each take n to copy
// Space Complexity : O(n) excluding output
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I iterate over the string and check for substrings which are palindrome, if it is palindrome, I search ahead and then backtrack

class Solution {
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(s.toCharArray(), 0, new ArrayList<>());
        return res;
    }

    public void helper(char[] arr, int idx, List<String> list){
        if (idx == arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i<arr.length; i++){
            if(isPalindrome(arr, idx, i)){
                list.add(new String(arr, idx, i - idx + 1));
                helper(arr, i + 1, list);
                list.remove(list.size() - 1);
            } 
        }
    }
    private boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left++] != arr[right--]) return false;
        }
        return true;
    }
}
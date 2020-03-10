// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I struggle with palindrome problems.

/**
 * @param {string} s
 * @return {string[][]}
 */
let result = [];
var partition = function(s) {
    if (!s || !s.length) return [[]];
    
    result = [];
    backtrack(s, [], 0);
    return result;
};

var backtrack = function(s, temp, index) {
    // Base Case
    if (index == s.length) {
        result.push([...temp]);
        return;
    }
    
    // Logic
    for (let i = index; i < s.length; i++) {
        if (isPalindrome(s, index, i)) {
            // Action
            temp.push(s.substring(index, i + 1));
            // Recursion
            backtrack(s, temp, i + 1);
            // Backtracking
            temp.pop();
        }
    }
};

var isPalindrome = function(s, left, right) {
    while (left < right) {
        if (s[left] != s[right]) return false;
        left++;
        right--;
    }
    return true;
};

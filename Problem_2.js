// Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

// TC: O(2^n)
// SC: O(n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

let isPalindrome = (s, start, end) => {
    // Check if is palindrome using 2 pointer method
    while (start < end) {
        if (s[start] !== s[end])
            return false;
        start++;
        end--;
    }
    return true;
}
let result;

let helper = (s, index, path) => {
    if (index === s.length) {
        console.log(path);
        result.push(Array.from(path));
        return;
    }

    for (let i = index; i < s.length; i++) {
        // Check id the substring is a palindrome, only then explore the combination
        if (isPalindrome(s, index, i)) {
            let str = s.slice(index, i + 1);
            path.push(str);
            helper(s, i + 1, path);
            path.pop();
        }
    }
}
/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function (s) {
    result = [];
    helper(s, 0, [])
    return result;
};
// Time Complexity : O(n 2^n) n for checking Palindrome and 2^n for recursion
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

var result;
var partition = function (s) {
    result = [];
    if (!s || s.length === 0) return result;
    helper(s, 0, []);
    return result;
};

var helper = function (s, index, path) {
    //base
    if (index === s.length) {
        result.push(path.slice());
        return;
    }

    //logic
    for (let i = index; i < s.length; i++) {
        if (isPalindrome(s, index, i)) {
            //action
            path.push(s.substring(index, i + 1));
            //recurse
            helper(s, i + 1, path);
            //bactrack
            path.pop();
        }
    }

}

var isPalindrome = function (s, l, r) {
    while (l < r) {
        if (s[l] !== s[r]) return false;
        l++;
        r--;
    }
    return true;
}
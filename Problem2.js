// ## Problem2

// Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)
// [Naive Approach] Using Recursion - O(n*2^n) Time and O(n) Space

// [Naive Approach] Using Recursion - O(n*2^n) Time and O(n) Space
//!pending [Better Approach 1] Using Top-Down DP (Memoization) - O(n^3) Time and O(n^2) Space
//!pending [Better Approach 2] Using Bottom-Up DP (Tabulation) - O(n^3) Time and O(n^2) Space
//!pending [Expected Approach] Using Optimised Bottom-Up DP (Tabulation) - O(n^2) Time and O(n^2) Space

var partition = function(s) {
    let res = []

    function helper(s,pivot,path){
        if(pivot == s.length){
            res.push([...path])
            return
        }
        for(let i = pivot;i<s.length;i++){
            let subString = s.substring(pivot,i+1)
            if(isPalindrome(subString)){
                path.push(subString)
                helper(s,i+1,path)
                path.pop()
            }
        }
    }
    helper(s,0,[])
    return res
};

function isPalindrome(s){
    let left = 0
    let right = s.length-1
    while(left<=right){
        if(s[left]!=s[right]) return false
        left++
        right--
    }
    return true
}
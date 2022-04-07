// Time Complexity : O(n*2^n) where n is number of nodes in a tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {string} s
 * @return {string[][]}
 */

let result;

// Logic to check if string is palindrom with two pointer solution
var isPalindrome = function(s) {
    let start = 0;
    let end = s.length-1;
    while(start<end) {
        if(s.charAt(start) !== s.charAt(end)) return false;
        start++;
        end--;
    }
    return true;
}

// helper function to implement recusrion and backtracking logic 
var helper = function(s, index, path) {
    //base case
    if(index === s.length) {
        result.push([...path]);
        return;
    }
    
    //logic
    for(let i = index; i < s.length; i++) {
        let curr = s.substring(index,i+1); //O(n)
        if(isPalindrome(curr)) { //O(n)
            //action
            path.push(curr);
            //recursion
            helper(s, i+1, path);
            //backtrack
            path.pop();
        }
        
    }
     
}

var partition = function(s) {
    result = [];
    if(s === null || s.length === 0) return result;
    helper(s, 0, []);
    return result;
};
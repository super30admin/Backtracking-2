// Time Complexity : O(2^n) where n is number of nodes in a tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Solved with 0-1 recursion
/**
 * @param {number[]} nums
 * @return {number[][]}
 */

let result;
var helper = function(nums, i, path) {
    //base case
    if(i === nums.length) {
        result.push([...path]); 
        return;
    }

    //not choose
    helper(nums, i+1, path);

    //choose
    path.push(nums[i]);
    helper(nums, i+1, path)

    //backtracking
    path.pop();  
}

var subsets = function(nums) {
    result = [];
    if(nums === null) return result;
    helper(nums, 0, []);
    
    return result;
};

// For loop based recursion solution
/*
let result;
var helper = function(nums, index, path) {
    //base case
    result.push([...path]); 
    
    //action
    for(let i=index; i < nums.length; i++) {
        path.push(nums[i]);
        helper(nums, i+1, path);
        path.pop();
    }
}

var subsets = function(nums) {
    result = [];
    if(nums === null) return result;
    helper(nums, 0, []);
    return result;
};
*/
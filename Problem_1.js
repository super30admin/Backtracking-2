// Subsets (https://leetcode.com/problems/subsets/)

// Recursion
// TC: O(2^n)
// SC: O(2^n)

// No recusrsion
// TC: O(2^n) -> 2 => Every time the result size increases by power of 2
// SC: O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

let result;

let helper = (nums, index, path) => {
    // Base
    if (index === nums.length) {
        result.push(Array.from(path));
        return;
    }

    // Logic
    // Do not select
    helper(nums, index + 1, path);
    // Select
    path.push(nums[index]);
    helper(nums, index + 1, path);
    path.pop();
}

let helperForLoop = (nums, index, path) => {
    // Base

    // Logic
    result.push(Array.from(path));
    for (let i = index; i < nums.length; i++) {
        path.push(nums[i]);
        helperForLoop(nums, i + 1, path);
        path.pop();
    }

}
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function (nums) {
    if (nums === null || nums.length === 0)
        return [];
    result = [];
    // helper(nums, 0, []);
    // helperForLoop(nums, 0, []);

    // No Recursion;
    result.push([]);
    for (let i = 0; i < nums.length; i++) {
        let resultLen = result.length;
        for (let j = 0; j < resultLen; j++) {
            let newArr = Array.from(result[j]);
            newArr.push(nums[i]);
            result.push(newArr);
        }
    }

    return result;
};
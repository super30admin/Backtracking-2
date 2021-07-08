// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
let result;
var subsets = function(nums) {
    if (!nums || !nums.length) return [[]];

    result = [];
    backtrack(nums, 0, []);
    return result;
};

var backtrack = function(nums, index, temp) {
    result.push([...temp]);
    for (let i = index; i < nums.length; i++) {
        // Action
        temp.push(nums[i]);
        // Recurse
        backtrack(nums, i + 1, temp);
        // Backtrack
        temp.pop();
    }
}

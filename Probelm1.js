// Time Complexity : O(2^n) n length of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

let result;
var subsets = function (nums) {
    result = [];
    if (!nums || nums.length === 0) return result;
    helper(nums, 0, []);
    return result;
};

var helper = function (nums, index, path) {
    result.push(path.slice());
    for (let i = index; i < nums.length; i++) {
        //action
        path.push(nums[i]);
        //recurse
        helper(nums, i + 1, path);
        //bactrack
        path.pop();
    }
}
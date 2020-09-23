//// Time Complexity : O(N^N)
//// Space Complexity : O(N^3) due to palindrome check at each node
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :

// internalizing backtracking problems

//// Your code here along with comments explaining your approach

///**
// * @param {number[]} nums
// * @return {number[][]}
// */
var subsets;

subsets = function(nums) {
  var backtracking, output;
  output = [];
  backtracking = function(index, path) {
    var i, j, ref, ref1, results;
    // base
    if (index >= nums.length) {
      output.push(path);
      return;
    }
    // recursive
    output.push(path);
    results = [];
    for (i = j = ref = index, ref1 = nums.length; (ref <= ref1 ? j < ref1 : j > ref1); i = ref <= ref1 ? ++j : --j) {
      results.push(backtracking(i + 1, [].concat(path, nums[i])));
    }
    return results;
  };
  if (nums.length === 0) {
    return [];
  }
  backtracking(0, []);
  return output;
};

//# sourceMappingURL=problem1-subset.js.map

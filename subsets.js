// Time Complexity : O(2^n) - exponential
// Space Complexity : O(n) - recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Backtracking approach
var subsets = function (nums) {
  const resultsArr = [];

  const dfs = (nums, index, path) => {
    // base
    if (index === nums.length) {
      // return new path because og path, gets emptied
      // once recursion unfolds
      resultsArr.push([...path]);
      return;
    }

    // logic
    // Zero case - do not choose
    dfs(nums, index + 1, path);

    // One case - choose
    // action
    path.push(nums[index]);
    // recurse
    dfs(nums, index + 1, path);
    // backtracking
    path.pop();
  };

  dfs(nums, 0, []);
  return resultsArr;
};

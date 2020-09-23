#// Time Complexity : O(N^N)
#// Space Complexity : O(N^3) due to palindrome check at each node
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#
# internalizing backtracking problems
#
#// Your code here along with comments explaining your approach


#/**
# * @param {number[]} nums
# * @return {number[][]}
# */
subsets = (nums) ->
  output = []

  backtracking = (index, path) ->
    # base
    if index >= nums.length
      output.push(path)
      return

    # recursive
    output.push(path)

    for i in [index...nums.length]
      backtracking(i + 1, [].concat(path, nums[i]))

  return [] if nums.length is 0

  backtracking(0, [])

  output

#// Time Complexity : O(N^N)
#// Space Complexity : O(N^3) due to palindrome check at each node
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#
# internalizing backtracking problems
#
#// Your code here along with comments explaining your approach
#
# recurse over the input string from 0 to input string length
# at each recursion,
#   base case: if you have exhausted your input, add path to output
#   build substrings upon substrings into a path
#   if a substring isn't a palindrome return immediately
#   keep recursing on remaining strings
#
# return output
partition = (s) ->

  output = []
  path = []

  isPalindrome = (s) ->
    left = 0
    right = s.length - 1

    while left < right
      return false if s[left] isnt s[right]
      left += 1
      right -= 1

    true

  # input, way to traverse, current path
  backtracking = (index, path) ->
    # base case
    if index >= s.length
      output.push(path)
      return

    # recursive
    for i in [index...s.length]
      temp = s.substring(index, i + 1)
      if isPalindrome(temp)
        backtracking(i + 1, [].concat(path).concat(temp))

  backtracking(0, path)

  output

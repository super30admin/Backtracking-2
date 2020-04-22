"""
// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :
Getting the right represenation of prefix value and postfix value
to consider unique set combinations
// Your code here along with comments explaining your approach
Algorithm explanation
The main idea is to iterate over the entire array and for each iteration,
divide into prefix and postfix and if the postfix is at least of size 1,
then recurse until we reach the end of the string
- In order to keep track of order of elements(1,2 same as 2,1), we use
set as intermediate data structure



"""

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        final_result = []
        def helper(nums):
            #base case
            if not nums:
                final_result.append(result[::])
                return

            #logic
            n = len(nums)
            for i in range(n):
                #action
                result.append(nums[:i])
                helper(nums[:i])
                #backtrack
                #result.pop()
                result.append(nums[i+1:])
                helper(nums[i+1:])
                #backtrack
                result.pop()
        
        n = len(nums)
        helper(nums)
        return final_result
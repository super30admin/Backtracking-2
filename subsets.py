"""
// Time Complexity : O(n*2^n)
// Space Complexity : O(n) without output space
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :
Getting the right represenation of prefix value and postfix value
to consider unique set combinations
// Your code here along with comments explaining your approach
Algorithm explanation
The main idea is to start from empty list in the recursion and
each recursive frame being valid add the result to output
Main logic
Loop over the element
- append the current ele to result
- recurse to i+1
- backtrack
"""
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        final_result = []
        
        def helper(nums,index):
            final_result.append(result[::])
            
            for i in range(index,len(nums)):
                result.append(nums[i])
                helper(nums,i+1)
                result.pop()
        helper(nums,0)
        return final_result
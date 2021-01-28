# Time Complexity : O(2*n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I do inorder traversal comparing whenever I reach node to see if it is greater than the previous root value
# Your code here along with comments explaining your approach
# I recurse using for loop to recurse through list adding the element at current index
# to path. This get us all the substring of the array

# https://leetcode.com/problems/subsets/

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        
        def helper(nums, index, path):
            result.append([x for x in path])
            for i in range(index, len(nums)):
                path.append(nums[i])
                helper(nums, i+1, path)
                path.pop()
                
        helper(nums, 0, [])
        return result
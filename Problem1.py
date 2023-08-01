
'''
Problem: Subsets
Time Complexity: O(2**n), where n is given elements
Space Complexity: O(n), for recursion
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        Two choices: to take or not to take
        add to path and then recurse
        undo action and then recurse   
'''

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        def dfs(nums, i, path):
            if i==len(nums):
                result.append(path[:])
                return 

            path.append(nums[i])
            dfs(nums, i+1, path)
            path.pop()
            dfs(nums, i+1, path)
        
        dfs(nums, 0, [])
        return result
            

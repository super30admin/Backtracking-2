# Time Complexity: O(n*2^n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        if nums == None or len(nums) == 0:
            return result
            
        def helper(nums, index, path):
            #base
            
            #logic
            result.append(list(path))
            for i in range(index, len(nums)):                                
                path.append(nums[i])
                helper(nums, i+1, path)
                path.pop()
                
        helper(nums, 0, [])
        return result
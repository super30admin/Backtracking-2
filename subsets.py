class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def helper(nums, index, path, result):
            # Base
            if index == len(nums):
                if path not in result:
                    temp = path[:]
                    result.append(temp)
                return result
            # Logic
            # Choose
            #Action
            path = path + [nums[index]]
            #Recurse
            helper(nums, index+1, path, result)
            #Backtrack
            path.pop()
            # Not Choose
            helper(nums, index+1, path, result)
            return result
            
        return helper(nums, 0, [], [])
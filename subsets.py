"""Approach: 0/1 recursion
TC O(2^N)
SC  O(N) Recusion stack space
"""
class Solution:
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # base
        if not nums or not isinstance(nums,list):
            return []
        result = []
        self.helper(nums, 0, [], result)
        return result
        
    def helper(self, nums, index, path, result):
        # base
        if index == len(nums):
            result.append(path[:])
            return
        
        # logic
        # don't choose
        self.helper(nums, index+1, path, result)
        # choose
        # action
        path.append(nums[index])
        # recurse
        self.helper(nums, index+1, path, result)
        # backtrack
        path.pop()


"""Approach: For Loop recursion
TC O(2^N)
SC  O(N) Recusion stack space
"""

class Solution:
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # base
        if not nums or not isinstance(nums,list):
            return []
        result = [[]]
        self.helper(nums, 0, [], result)
        return result
        
    def helper(self, nums, index, path, result):
        # logic
        # action
        for i in range(index, len(nums)):
            path.append(nums[i])
            result.append(path[:])
            # recurse
            self.helper(nums, i+1, path, result)
            # backtrack
            path.pop()

"""Approach: For loop - no recursion
TC O(2^N)
SC O(1) as all copy of list we will use add it to the path.
"""
class Solution:
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # base
        if not nums or not isinstance(nums,list):
            return []
        result = [[]]
        for n in nums:
            for j in range(len(result)):
                # create copy of each result[j] list using [:]
                t = result[j][:]
                # append n to that copy
                t.append(n)
                # append copy to result
                result.append(t)
        return result
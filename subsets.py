# Did this code successfully run on Leetcode : YES

# TC: O(2^N)
# SC: O(N)

# choose not-choose recursion

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        
        def helper(index=0, path=[]):
            # base
            if index == len(nums):
                result.append(list(path))
                return
            # logic
            # choose
            path.append(nums[index])
            helper(index+1, path)
            path.pop()
            # not choose
            helper(index+1, path)
            
        helper()
        return result

# backtracking

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        
        def helper(index=0, path=[]):
            result.append(list(path))
            for i in range(index, len(nums)):
                path.append(nums[i])
                helper(i+1, path)
                path.pop()
            
        helper()
        return result
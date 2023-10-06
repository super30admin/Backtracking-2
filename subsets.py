# Time Complexity: O(2^n) where n is the length of the list
# Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        def helper(nums, index, path):
            # base
            if index == len(nums):
                self.result.append(list(path))
                return 
            # action
            # choose
            path.append(nums[index])
            helper(nums, index +1, path )
            path.pop()
						# not choose
            helper(nums, index + 1, path)
        helper(nums, 0, [])
        return self.result


##################################

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        def helper(nums, index, path):
            self.result.append(list(path))
            for i in range(index, len(nums)):
                path.append(nums[i])
                helper(nums, i+1, path)
                path.pop()
        helper(nums, 0, [])
        return self.result


###############################

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.result.append([])
        for i in nums:
            k = len(self.result)
            for j in range(0,k):
                l = list(self.result[j])
                l.append(i)
                self.result.append(l)
        return self.result

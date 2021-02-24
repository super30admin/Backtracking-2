'''
Time complexity: O(n * 2^n) => n needed to put in output array
Space complexity: O(n)
'''
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.output = []
        if nums is None or len(nums) == 0:
            return self.output
        self.backtracking(nums, 0, [])
        return self.output
    
    def backtracking(self, nums, index, path):
        self.output.append(list(path))
        for i in range(index, len(nums)):
            path.append(nums[i])
            self.backtracking(nums, i+1, path)
            path.pop()
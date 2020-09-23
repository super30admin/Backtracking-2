class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        output = []
        path = []
        
        self.backtracking(output, nums, 0, path)
        return output
        
    def backtracking(self, output, nums, index, path):        
        #base case
        output.append(deepcopy(path))

        #recursive case
        for i in range(index, len(nums)):
            path.append(nums[i])
            self.backtracking(output, nums, i + 1, path)
            path.pop()

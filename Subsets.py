# Time Complexity - O(N * 2^N)
# Space Complexity - O(N * 2^N)
class Solution:
    def subsets(self, nums):
        output = []
        self.backtrack(nums, 0, [], output)
        return output
        
    def backtrack(self, nums, index, currentList, output):
        output.append(list(currentList))
        for i in range(index, len(nums)):
            current = nums[i]
            currentList.append(current)
            self.backtrack(nums, i+1, currentList, output)
            currentList.pop(-1)
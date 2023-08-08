# Time Complexity: O(2^N)
# Space Complexity: O(N)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums: List[int], pivot: int, path: List[int]):
        # bas
        self.result.append(path[:])
        # logic
        for i in range(pivot, len(nums)):
            path.append(nums[i])
            self.helper(nums, i+1, path)
            path.pop()
        

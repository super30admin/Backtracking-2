class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        
        self.helper(nums, 0, [])

        return self.result 

    def helper(self, nums, pivot, path):

        # Logic
        self.result.append(list(path))

        for i in range(pivot, len(nums)):
            # Action
            path.append(nums[i])
            # Recurse
            self.helper(nums, i+1, path)
            # Backtrack
            path.pop()


# Time complexity: O(n * 2^n)
# Space complexity: O(n)


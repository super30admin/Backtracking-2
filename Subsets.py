# Time Complexity : O(2^n * n), where n is the num of elements in nums and 2^n is the recursive stack space in which the result has to be inserted
# Space Complexity : O(2^n * n)
class Solution:
    def subsets(self, nums):
        if nums is None or len(nums) == 0:
            return []
        self.result = []
        self.generate_subset(0, nums, [])
        return self.result

    def generate_subset(self, index, nums, current):
        self.result.append(list(current))
        for i in range(index, len(nums)):
            current.append(nums[i])
            self.generate_subset(i + 1, nums, current)
            current.pop()  # Backtracking

# Example 1
solution = Solution()
print(solution.subsets([1, 2, 3]))

# Example 2
solution = Solution()
print(solution.subsets([0]))

# Example 3
solution = Solution()
print(solution.subsets([1, 2, 2]))
# Time complexity: O(2^N)
# Space complexity: O(2^N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def subsets(self, nums: [int]):
        result = []
        self.backtracking(result, 0, [], nums)
        return result

    def backtracking(self, result, start, temp, nums):
        result.append(list(temp))
        for i in range(start, len(nums)):
            temp.append(nums[i])
            self.backtracking(result, i + 1, temp, nums)
            temp.pop()


r = Solution()
nums = [1, 2, 3]
print("All possible subsets are:", r.subsets(nums))

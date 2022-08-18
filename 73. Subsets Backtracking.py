# backtracking solution
class Solution:
    result = []

    def subsets(self, nums):
        self.result = []
        self.helper(nums, 0, [])
        return print(self.result)

    def helper(self, nums, index, path):
        if index == len(nums):
            self.result.append(path.copy())
            return
        # not choose case
        self.helper(nums, index + 1, path)  # recurse
        # action
        path.append(nums[index])
        # choose case
        self.helper(nums, index + 1, path)  # recurse
        path.pop(-1)  # backtrack


if __name__ == "__main__":
    obj = Solution()
    obj.subsets([1, 2, 3, 4])

# TC =O(2^n).
# Space complexity : O(2^n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution:
    result = []

    def subsets(self, nums):
        self.result = []
        self.helper(nums, 0, path=[])
        return print(self.result.sort())

    def helper(self, nums, index, path):
        # base
        self.result.append(path.copy())
        # logic
        for i in range(index, len(nums)):
            # action
            path.append(nums[i])
            # recurse
            self.helper(nums, i + 1, path)
            # backtrack
            path.pop(-1)


if __name__ == "__main__":
    obj = Solution()
    obj.subsets([1, 2, 3, 4])

# [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3],[4],[1,4],[2,4],[1,2,4],[3,4],[1,3,4],[2,3,4],[1,2,3,4]]

# Time Complexity = O(2^n)
# Space complexity : O(2^n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

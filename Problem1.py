# Time Complexity = O(2^n) | Space Complexity = O(n) - 0/1 recursion

class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        self.result = []
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums: list[int], i: int, path: list[int]):

        # base case
        if i == len(nums):
            self.result.append(list(path))
            return
        # logic
        # no choose
        self.helper(nums, i + 1, path)
        # choose
        # action
        path.append(nums[i])
        # recurse
        self.helper(nums, i + 1, path)
        # backtrack
        del path[-1]

# Time Complexity = O(2^n) | Space Complexity = O(n) - for loop recursion

class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        self.result = []
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums: list[int], pivot: int, path: list[int]):
        # base case
        self.result.append(list(path))

        # logic
        for i in range(pivot, len(nums)):
            path.append(nums[i])
            self.helper(nums, i + 1, path)
            del path[-1]

# Time Complexity =  O(2^n)   - only for loop

class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        result = []
        result.append([])
        for i in range(len(nums)):
            for j in range(len(result)):
                temp = list(result[j])
                temp.append(nums[i])
                result.append(temp)

        return result
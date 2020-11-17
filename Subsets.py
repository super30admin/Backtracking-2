#Time Complexity : O(2^n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Using backtracking, keeping a temp array and an index (which iterates through the main array), we append the curr index element in the temp array and at the beginning of every recursive call we append a copy of temp array to the resulting array. Each time on calling the backtracking we increment the index as we do not want to use the same element again.

class Solution:
    def backtrack(self, nums, curr, index):
        self.result.append(copy.deepcopy(curr))

        for i in range(index, len(nums)):
            curr.append(nums[i])
            self.backtrack(nums, curr, i+1)
            curr.pop()

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.backtrack(nums, [], 0)
        return self.result


    #RECURSION
    #     def helper(self, nums, curr, index):
    #         #base
    #         if index == len(nums):
    #             self.result.append(copy.deepcopy(curr))
    #             return
    #         #logic
    #         #don't choose
    #         self.helper(nums, curr, index+1)
    #         #choose
    #         self.helper(nums, curr+[nums[index]], index+1)

    #     def subsets(self, nums: List[int]) -> List[List[int]]:
    #         self.result = []

    #         self.helper(nums, [], 0)

    #         return self.result

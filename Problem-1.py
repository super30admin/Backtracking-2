#Approach
#add varaible to the sum if summ equal to target radd the path else proceed with the sum if total sum is lees than
# target

#Complexity
#Time :o(2^n)
#Space: o(n)



from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        subSets = []
        self.helper(nums, result, subSets, 0)
        return result

    def helper(self, nums, result, subSets, index):
        if index == len(nums):
            result.append(subSets.copy())
            return

        subSets.append(nums[index])
        self.helper(nums, result, subSets, index + 1)
        subSets.pop(-1)
        self.helper(nums, result, subSets, index + 1)


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        subSets = []
        result.append(subSets.copy())
        self.helper(nums, result, subSets, 0)
        return result

    def helper(self, nums, result, subSets, pivot):
        if pivot == len(nums):
            return

        for i in range(pivot, len(nums)):
            subSets.append(nums[i])
            result.append(subSets.copy())
            self.helper(nums, result, subSets, i + 1)
            subSets.pop(-1)





#TC: O(2^n)
#SC: O(n x 2^n)
class Solution:

    def __init__(self):
        self.finalList = []
        self.tempList = []

    def __backtracking(self, nums, idx):
        self.finalList.append(list(self.tempList))
        for indexIter in range(idx, len(nums)):
            self.tempList.append(nums[indexIter])
            self.__backtracking(nums, indexIter + 1)
            self.tempList.pop()
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if (nums == None or len(nums) == 0):
            return self.finalList
        self.__backtracking(nums, 0)
        return self.finalList


class Subsets_Recursion(object):
    def __init__(self):
        self.finalList = []

    def __recursionHelper(self, nums, index, tempList):
        if (index == len(nums)):
            self.finalList.append(tempList)
            return
        self.__recursionHelper(nums, index + 1, list(tempList))
        tempList.append(nums[index])
        self.__recursionHelper(nums, index + 1, list(tempList))

    def subsets(self, nums):
        if (nums == None or len(nums) == 0):
            return self.finalList
        self.__recursionHelper(nums, 0, [])
        return self.finalList
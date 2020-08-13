'''
Solution:
1.  This can be solved using either recursion or backtracking.
2.  Using recursion, we create a new list each time we call recursion, once choosing the element and once not choosing
    the element.
3.  Using backtracking, we update the same list we call backtracking each time and whenever we have to append the result,
    we create a copy of the list and add.

Time Complexity:    O(2^n) for both the cases
Space Complexity:   O(n x 2^n) for recursion and O(n) for Backtracking

--- Passed all testcases on Leetcode successfully
'''


class Subsets_Backtracking(object):

    def __init__(self):
        self.finalList = []
        self.tempList = []

    def __backtracking(self, nums, idx):

        self.finalList.append(list(self.tempList))

        #   from current index to total length
        for indexIter in range(idx, len(nums)):

            #   action -- appending the current element to the list
            self.tempList.append(nums[indexIter])

            #   recursion -- just to add the updated list to the final result
            self.__backtracking(nums, indexIter + 1)

            #   backtrack -- removing the current element from the list
            self.tempList.pop()

    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        #   edge case check
        if (nums == None or len(nums) == 0):
            return self.finalList

        #   main call to the helper function
        self.__backtracking(nums, 0)

        #   return the final list
        return self.finalList


class Subsets_Recursion(object):

    def __init__(self):
        self.finalList = []

    def __recursionHelper(self, nums, index, tempList):

        #   base case
        if (index == len(nums)):
            self.finalList.append(tempList)
            return

        #   don't choose the element
        self.__recursionHelper(nums, index + 1, list(tempList))

        #   choose the element
        tempList.append(nums[index])
        self.__recursionHelper(nums, index + 1, list(tempList))

    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        #   edge case check
        if (nums == None or len(nums) == 0):
            return self.finalList

        #   main call to the helper function
        self.__recursionHelper(nums, 0, [])

        #   return the final list
        return self.finalList
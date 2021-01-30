# Created by Aashish Adhikari at 12:21 PM 1/29/2021

'''
Time Complexity:
At each node, we are copying the current solution. O(k) where k is the average length of an element in the subset.
We are reaching a maximum of 2 ^n nodes

O(k . 2^(n))

Space Complexity:
O(n) since at the worst case, the maintained current solution array has all the elements in the original array.
'''

class Solution(object):


    def backtrack(self, nums, pos, current_sol):


        if pos == len(nums):
            self.sols.append(copy.deepcopy(current_sol))

        else:

            self.sols.append(copy.deepcopy(current_sol))

            for idx in range(pos, len(nums)):




                current_sol.append(nums[idx])

                self.backtrack(nums, idx+1, current_sol)

                current_sol.pop()






    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        if len(nums) == 0:
            return [[]]

        self.sols = []

        self.backtrack(nums, 0, [])

        return self.sols



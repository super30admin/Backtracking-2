# Created by Aashish Adhikari at 11:45 AM 1/29/2021

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
            pass
        else:


            # take case
            current_sol.append(nums[pos])
            self.sols.append(copy.deepcopy(current_sol)) # creating a new copy so that we can continue using the original copy for backtracking
            self.backtrack(nums, pos+1, current_sol)



            # dont take case
            current_sol.pop()  #remove the last added element
            self.backtrack(nums, pos+1, current_sol)





    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        if len(nums) == 0:
            return [[]]

        self.sols = [[]]

        self.backtrack(nums, 0, [])

        return self.sols



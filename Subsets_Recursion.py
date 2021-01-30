# Created by Aashish Adhikari at 11:39 AM 1/29/2021


class Solution(object):


    def recursion(self, nums, pos, current_sol):


        # base case
        if pos == len(nums):
            pass

        else:

            # dont take case
            copy1 = copy.deepcopy(current_sol)

            self.recursion(nums, pos+1, copy1)


            # take case
            current_sol.append(nums[pos])

            # a new combination is formed only when a new element is added, so add this to the list of solutions
            self.sols.append(copy.deepcopy(current_sol))
            self.recursion(nums, pos+1, current_sol)# even if take case, increase the position as the numbers cannot repeat

    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        if len(nums) == 0:
            return [[]]
        self.sols = [[]]
        self.recursion(nums, 0, [])
        return self.sols



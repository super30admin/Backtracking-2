'''
S30 problem.

Followed the 0-1 recursion pattern.

Understand that that all the results gonna present in the leafnodes, which is the key to solve the problem.

Pen and Paper Must.

TC: O(2^n) n--> number of elements in the list.
SC: O(n) --> Stack Spcce
'''

import copy
class Solution:

    def __init__(self):
        self.result =[]

    def subsets(self, nums: List[int]) -> List[List[int]]:
        path =[]
        self.helper(nums, 0, path)
        return self.result



    def helper(self, nums, i, path ):


        # Base case
        if(i==len(nums)):
            self.result.append(copy.deepcopy(path))
            return

        #no choose
        self.helper(nums, i+1, path)

        #choose

        #Action
        path.append(nums[i])

        #Recursion
        self.helper(nums,i+1, path)

        #BackTrack
        path.pop()

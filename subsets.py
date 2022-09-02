import copy
class Solution(object):
    def __init__(self):
        self.result=[]
    def helper(self, nums, path, index):
        #TC: O(2^N)
        #SC: O(N)
        #Base case
        if index==len(nums):
            self.result.append(copy.deepcopy(path))
            return
        #Logic
        #No choose
        self.helper(nums, path, index+1)
        
        #Choose
        #ACTION
        path.append(nums[index])
        #Recurse
        self.helper(nums, path, index+1)
        #Backtrack
        path.pop()
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        #BACKTRACK
        self.helper(nums, [], 0)
        return self.result
        

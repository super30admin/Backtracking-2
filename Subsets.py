# Time Complexity:
# O(2^n * n)       n  = Length of string  [2^n Exponential for each char under consideration, due to recursion]


# Space Complexity:  
# O(2^n * n)       Exponential, due to recursion stack space

# Approach: 
# For-loop based Backtracking

class Solution(object):
    def __init__(self):
        self.result = []
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # =========================> Approach -> For-loop Backtracking <========================= //
        if not nums or len(nums)==0:
            return
        
        self.backtrack(nums, 0, [])
        return self.result
    
    def backtrack(self, nums, index, path):
        # add the current path to result every time
        #print("Current path:", path)
        self.result.append(list(path))

        for i in range(index, len(nums)):
            # add num to path
            path.append(nums[i])
            # recurse
            self.backtrack(nums, i+1, path)
            # backtrack
            path.pop(len(path)-1)
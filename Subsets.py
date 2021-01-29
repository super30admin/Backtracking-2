# Recursion
class Solution:
    def __init__(self):
        self.result = []
        
    def subsets(self, nums):
        if nums == None or len(nums) == 0: return self.result
        self.helper(nums, [], 0)
        return self.result
    
    def helper(self, nums, path, index):
        # base
        if index == len(nums):
            self.result.append(path)
            return 
        # logic
        # dont choose
        self.helper(nums, path.copy(), index+1)
        # choose
        path.append(nums[index])
        self.helper(nums, path.copy(), index+1)
        
# Backtrack
class Solution:
    def __init__(self):
        self.result = []
        
    def subsets(self, nums):
        if nums == None or len(nums) == 0: return self.result
        self.helper(nums, [], 0)
        return self.result
    
    def helper(self, nums, path, index):
        # base
        if index == len(nums):
            self.result.append(path.copy())
            return 
        # logic
        # dont choose
        self.helper(nums, path, index+1)
        # choose
        path.append(nums[index])
        self.helper(nums, path, index+1)
        # backtrack
        path.pop()

# TC: O(n)
# SC: O(n)
# Pivot backtrack
# Keeping pivot and iterating over rest elements while exhausting each element considered. Here, each recursive call gets u valid path for result. 
class Solution:
    def __init__(self):
        self.result = []
        
    def subsets(self, nums):
        # edge
        if nums == None or len(nums) == 0: return self.result
        self.helper(nums, [], 0)
        return self.result
    
    def helper(self, nums, path, index):
        # append copy to retain current state
        self.result.append(path.copy())
        for i in range(index, len(nums)):
            # action
            path.append(nums[i])
            # recurse
            self.helper(nums, path, i+1)
            # backtrack
            path.pop()
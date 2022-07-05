#78. subsets
"""
Time Complexity : O(2^n)
Space Complexity : O(n)

"""
class Solution:
    result = []
    
    def helper(self, nums, index, path):
        #base
        
        self.result.append(list(path))
        #print(self.result)
        if index == len(nums):    
            #print(self.result, "here")
            return
        
        #logic
        for i in range(index, len(nums)):
            #action
            #temp = list(path)
            path.append(nums[i])
            #recurse
            self.helper(nums, i+1, path)
            #backtrack
            path.pop()
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        #null
        
        #logic
        self.helper(nums, 0, [])
        return self.result

# Time complexity - O(n* 2^n) # creates a new list - O(n)
# Space complexity - O(n* 2^n)
# Did your solution run on leetcode? - yes
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.subsets = [[]]
        self.recursion(nums, 0, [])    
        return list(self.subsets)
    
    def recursion(self, nums, idx, subset):
        # base case
        if idx >= len(nums):
            return 
        
        # logic
        # add a number to the subset
        temp = copy.copy(subset)
        temp.append(nums[idx])
        
        # check if the set is present in the subsets
        self.subsets.append(temp)   # creates a new address in the memory for the list
        
        # proceed to the next index # choose
        self.recursion(nums, idx+1, temp)
        
        
        # proceed to the next index # not choose
        self.recursion(nums, idx+1, subset)

        
# Time complexity - O(n * 2^n) # creates a new list in the result - O(n)
# Space complexity - O(2^n)
# Did your solution run on leetcode? - yes
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.subsets = []
        self.backtrack(nums, 0, [])
        return self.subsets
    
    def backtrack(self, nums, start, subset):   
        self.subsets.append(list(subset))   # no extra space - part of the result array
        # logic
        for idx in range(start, len(nums)):
            # action
            subset.append(nums[idx])

            # recurse
            self.backtrack(nums, idx+1, subset)

            # backtrack
            subset.pop()
        
        
# Time complexity - O(n * 2^n)
# Space complexity - O(n * 2^n)
# Did this solution run on leetcode? - yes
# Leetcode solution - using binary masks
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        if n==0:
            return [[]]
        
        outputs = []
        
        for i in range(2**n, 2**(n+1)):
            # find the bit mask - we want bitmask of length n 
            mask = bin(i)[3:]
            
            # append the subsets to the output
            outputs.append([nums[i] for i in range(n) if mask[i]=="1"])
            
        return outputs
            
        
        


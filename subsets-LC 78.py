# Time Complexity = exponential (O(2^n)), where n is the length of nums


# Iterative Solution
class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        if nums == None:
            return [[]]
        
        result = []
        result.append([])
        
        # Iterate over the nums array
        for i in range(0, len(nums)):
            # Calculate size of result array at each iteration
            size = len(result)
            # Iterate over result array, copy each sublist, append nums[i] to it and add the new sublist in the result array
            for j in range(0, size):
                newlist = result[j].copy()
                newlist.append(nums[i])
                result.append(newlist)
                
        
        return result
        
        
        


# For loop based Recursion with Backtracking
class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        if nums == None:
            return [[]]
        
        self.result = []
        
        self.helper(nums, 0, [])
        
        return self.result
    
    
    
    def helper(self, nums, index, path):
        # Base Case
        
        
        # Logic
        self.result.append(path.copy())
        for i in range(index, len(nums)):
            # Action
            path.append(nums[i])
            
            # Recursion
            self.helper(nums, i + 1, path)
            
            # backtrack
            path.pop(len(path) - 1)
     
        

# For loop based Recursion
class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        if nums == None:
            return [[]]
        
        self.result = []
        
        self.helper(nums, 0, [])
        
        return self.result
    
    
    
    def helper(self, nums, index, path):
        # Base Case
        
        
        # Logic
        self.result.append(path)
        for i in range(index, len(nums)):
            # Action
            new = path.copy()
            new.append(nums[i])
            
            # Recursion
            self.helper(nums, i + 1, new.copy())
            
            




# Choose/Not choose Recursion using Backtracking 
class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        if nums == None:
            return [[]]
        
        self.result = []
        
        self.helper(nums, 0, [])
        
        return self.result
    
    
    def helper(self, nums, index, path):
        # Base Case
        if index == len(nums):
            self.result.append(path.copy())
            return
        
        
        # Logic
        # 0 case or not choose
        self.helper(nums, index + 1, path)
        
        # 1 case or choose
        # Action
        path.append(nums[index])
        
        # Recurse
        self.helper(nums, index + 1, path)
        
        # Backtrack
        path.pop(len(path) - 1)





# Recursive Approach - Choose/Not Choose
class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        if nums == None:
            return [[]]
        
        self.result = []
        
        self.helper(nums, 0, path)
        
        return self.result
    
    
    def helper(self, nums, index, path):
        # Base Case
        if index == len(nums):
            self.result.append(path)
            return
        
        
        # Logic
        # 0 case or not choose
        self.helper(nums, index + 1, path.copy())
        
        # 1 case or choose
        path.append(nums[index])
        self.helper(nums, index + 1, path.copy())
        
        

        
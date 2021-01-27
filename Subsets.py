class Solution:
    #Solution 1
    def subsets(self, nums: List[int]) -> List[List[int]]:
        #Approach: Recursion with backtracking
        #Time Complexity: O(n * 2^n)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        self.result = []
        self.backtracking(nums, 0, [])
        return self.result
    
    def backtracking(self, nums, pivot, path):
        #base
        self.result.append(path.copy())
        
        #logic
        for i in range(pivot, len(nums)):
            #action
            path.append(nums[i])
            
            #recursion
            self.backtracking(nums, i + 1, path)
            
            #backtracking
            path.pop()
    
    #Solution 2
    """
    def subsets(self, nums: List[int]) -> List[List[int]]:
        #Approach: Recursion with backtracking
        #Time Complexity: O(n * 2^n)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        self.result = []
        self.backtracking(nums, 0, [])
        return self.result
    
    def backtracking(self, nums, idx, path):
        #base
        if idx == len(nums):
            self.result.append(path.copy())
            return
        
        #logic
        #not choose
        self.backtracking(nums, idx + 1, path)
        
        #choose
        path.append(nums[idx])
        self.backtracking(nums, idx + 1, path)
        
        #backtracking
        path.pop()
    """
    
    #Solution 3
    """
    def subsets(self, nums: List[int]) -> List[List[int]]:
        #Approach: Recursion
        #Time Complexity: O(n * 2^n)
        #Space Complexity: O(n * 2^n)   // deep copy of path at every node
        #where, n is the length of nums
        
        self.result = []
        self.helper(nums, 0, [])
        return self.result
    
    def helper(self, nums, idx, path):
        #base
        if idx == len(nums):
            self.result.append(path)
            return
        
        #logic
        #not choose
        self.helper(nums, idx + 1, path.copy())
        
        #choose
        path.append(nums[idx])
        self.helper(nums, idx + 1, path.copy())
    """
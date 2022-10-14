"""
FAANMG Problem #73 {Medium} 


78. Subsets

Time complexity : O(N * 2^N)
Space complexity : O(H)


Did this code successfully run on Leetcode : Yes

For loop based Recursive Solution 

@name: Rahul Govindkumar_RN27JUL2022
"""  

class Solution:

        
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        result=[[]]
        
        for  i in range(len(nums)):
            
            size = len(result)
            for j in range(size):
                
                temp =list(result[j])
                temp.append(nums[i])
                result.append(temp)
                
        return result


"""
FAANMG Problem #73 {Medium} 


78. Subsets

Time complexity : O(N * 2^N)
Space complexity : O(H)


Did this code successfully run on Leetcode : Yes

For loop based Recursive Solution 

@name: Rahul Govindkumar_RN27JUL2022
"""  

class Solution:
    
    def helper(self, nums, idx, path):
        
        #base
   
        
        #logic
        
        self.result.append(path)
        for i in range (idx, len(nums)):
            
            temp =list(path)
            temp.append(nums[i])
            self.helper(nums, i+1, temp)
        
       
        
        
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        self.result =[]
        
        self.helper(nums, 0, [] )
        
        return self.result
    
        
    
"""
FAANMG Problem #73 {Medium} 


78. Subsets

Time complexity : O(N * 2^N)
Space complexity : O(H)


Did this code successfully run on Leetcode : Yes

For loop based Recursive Solution : Backtrack

@name: Rahul Govindkumar_RN27JUL2022
"""      
    

class Solution:
    
    def helper(self, nums, idx, path):
        
        #base
   
        
        #logic
        
        self.result.append(path.copy())
        for i in range (idx, len(nums)):
            
      
            path.append(nums[i])
            self.helper(nums, i+1, path)
            path.pop()
        
       
        
        
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        self.result =[]
        
        self.helper(nums, 0, [] )
        
        return self.result
    

"""
FAANMG Problem #73 {Medium} 


78. Subsets

Time Complexity :O(2^N) 
                  N: len of nums array
Space Complexity :O(N)


Did this code successfully run on Leetcode : Yes

0 1 Recursive Solution 

@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    
    def helper(self, nums, idx, path):
        
        #base
        if idx == len(nums):
            
            self.result.append(path)
            return 
        
        #logic
        #not choose
        self.helper(nums, idx+1, list(path))
        
        #choose
        path.append(nums[idx])
        self.helper(nums, idx+1, list(path))

        
        
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        self.result =[]
        
        self.helper(nums, 0, [] )
        
        return self.result
    
        
    
"""
FAANMG Problem #73 {Medium} 


78. Subsets

Time Complexity :O(2^N) 
                  N: len of nums array
Space Complexity :O(N)


Did this code successfully run on Leetcode : Yes

0 1 Recursive Solution : Backtrack

@name: Rahul Govindkumar_RN27JUL2022
"""    
    
    

class Solution:
    
    def helper(self, nums, idx, path):
        
        #base
        if idx == len(nums):
            
            self.result.append(path.copy())
            return 
        
        #logic
        #not choose
        self.helper(nums, idx+1, path)
        
        #action
        #choose
        path.append(nums[idx])
        
        #recurse
        self.helper(nums, idx+1, path)
        
        #backtrack
        path.pop()

        
        
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        self.result =[]
        
        self.helper(nums, 0, [] )
        
        return self.result
    
        

        
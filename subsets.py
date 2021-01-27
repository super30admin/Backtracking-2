## Approach: Recursion with deep copying
# Time - O(2 ^ N * N) we make 2 choices at each node and O(N) for deep copy while adding to result
# Space - O(2 ^ N * N) # since deep copying at each node is done here in recursion

def subsets(self, nums: List[int]) -> List[List[int]]:
    self.result = []
    if not nums or len(nums) == 0:
        return self.result
    
    self.helper(nums, 0, [])
    return self.result


def helper(self, nums, i, paths):
    
    # base case
    if i == len(nums):
        self.result.append(paths)
        return
    
    # logic
    
    # dont choose
    self.helper(nums, i+1, paths.copy())
    
    #choose # here we choose i + 1 as we have unique numbers and connot choose same number
    paths.append(nums[i])
    self.helper(nums, i+1, paths.copy())



## Approach2: Backtracking
# Time - O(2 ^ N * N) we make 2 choices at each node and O(N) for deep copy while adding to result
# Space - O(N) # since no deep copying at each node is done in backtracking approach

def subsets(self, nums: List[int]) -> List[List[int]]:
    self.result = []
    if not nums or len(nums) == 0:
        return self.result
    
    self.helper(nums, 0, [])
    return self.result


def helper(self, nums, i, paths):
    
    # base case
    if i == len(nums):
        self.result.append(paths.copy())
        return
    
    # logic
    
    # dont choose
    self.helper(nums, i+1, paths)
    
    #choose
    paths.append(nums[i])
    self.helper(nums, i+1, paths)

    # backtrack
    paths.pop()
            
        

## Approach: With pivot
# Time - O(2 ^ N * N) we make 2 choices at each node and O(N) for deep copy while adding to result
# Space - O(N) # since no deep copying at each node is done in backtracking approach   

class Solution:
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        if not nums or len(nums) == 0:
            return self.result
        
        self.helper(nums, 0, [])
        return self.result
    
    
    def helper(self, nums, index, paths):
        
        # base case
        self.result.append(paths.copy())
      
        # logic
        for i in range(index, len(nums)):
            #action
            paths.append(nums[i])
            #recurse
            self.helper(nums, i + 1, paths)
            paths.pop()
            
        
            
# Approach 1 recursion
# TC - O(n* 2 ** n) - exponential
# SC - O(2**n)

class Solution:
    def __helper(self, nums: List[int], index: int, path: List[int]):
        # base
        if (index == len(nums)):
            self.result.append(path)
            return
        #Zlogic
        # do not choose
        self.__helper(nums, index + 1, path.copy())
        
        # pick case
        path.append(nums[index])
        self.__helper(nums, index + 1, path.copy())
        
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums or len(nums) == 0:
            return []
        
        self.result = []
        
        self.__helper(nums, 0, [])
        return self.result
    
# Approach 2 - Backtracking
# Approach 1 recursion
# TC - O(n* 2 ** n) - exponential
# SC - O(2**n)

class Solution:
    def __helper(self, nums: List[int], index: int, path: List[int]):
        # base
        if (index == len(nums)):
            self.result.append(path.copy())
            return
        #Zlogic
        
        # action
        path.append(nums[index])
        
        # do not choose
        self.__helper(nums, index + 1, path)
        path.pop(len(path) - 1)
        
        # pick case
        self.__helper(nums, index + 1, path)
        
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums or len(nums) == 0:
            return []
        
        self.result = []
        
        self.__helper(nums, 0, [])
        return self.result
    
    
# Approach 3 iteration
# TC - O(n* 2 ** n) - exponential
# SC - O(2**n)

class Solution:
    def __helper(self, nums: List[int], index: int, path: List[int]):
        self.result.append(path.copy())
        for i in range(index, len(nums)):
            # action
            path.append(nums[i])

            # recurse
            self.__helper(nums, i + 1, path)
            path.pop(len(path) - 1)
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums or len(nums) == 0:
            return []
        
        self.result = []
        
        self.__helper(nums, 0, [])
        return self.result
'''
Time Complexity: 0(2^n) 
Space Complexity: Recusrion Stack 0(n)
'''

# for loop recursion
class Solution:
    res = list()
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = list()
        self.helper(nums, 0, [])
        return self.res
    
    
    def helper(self, nums, index, path):
        
        self.res.append(path.copy())
        
        
        for i in range(index, len(nums)):
            path.append(nums[i])
            self.helper(nums, i+1, path)
            path.pop()


# with two for loops
'''
Time Complexity: 0(2^n) 
Space Complexity: None
'''
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = list()
        result.append(list())
        for i in range(len(nums)):
            curr = nums[i]
            size = len(result)
            for j in range(size):
                temp = result[j].copy()
                temp.append(curr)
                result.append(temp)
        return result

# DFS
'''
Time Complexity: 0(2^n)
Space Complexity: Recusrion Stack 0(n)
'''
class Solution:
    res = list()
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = list()
        self.helper(nums, 0, [])
        return self.res
    
    
    def helper(self, nums, i, path):
        if i == len(nums):
            self.res.append(path.copy())
            return
        
        self.helper(nums, i+1, path)
        path.append(nums[i])
        self.helper(nums, i+1, path)
        path.pop()
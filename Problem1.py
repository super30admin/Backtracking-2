# Time Complexity :- Exponential 
# Space Complexity :- recursive stack space 
# Iterative approach  recursive

class Solution:
    mainList = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.mainList = []

        self.helper(nums, 0, [])
        return self.mainList
    
    def helper(self, nums, index, path):

        self.mainList.append(path)
        for i in range(index, len(nums)):
            newList = path.copy()
            newList.append(nums[i])
            self.helper(nums, i+1, newList)

## Iterative backtracking approach 
class Solution:
    mainList = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.mainList = []

        self.helper(nums, 0, [])
        return self.mainList
    
    def helper(self, nums, index, path):

        self.mainList.append(path.copy())
        for i in range(index, len(nums)):
            path.append(nums[i])
            self.helper(nums, i+1, path)
            path.pop()

# Recursive backtracking approach 
class Solution:
    mainList = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.mainList = []
        self.helper(nums, 0, [])
        return self.mainList
    
    def helper(self, nums, index, path):
            if index == len(nums):
                self.mainList.append(path.copy())
                return
            self.helper(nums, index+1, path)
            path.append(nums[index])
            self.helper(nums, index+1,path)
            path.pop()



# Just Recursive approach : -
class Solution:
    mainList = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.mainList = []
        self.helper(nums, 0, [])
        return self.mainList
    
    def helper(self, nums, index, path):
            if index == len(nums):
                self.mainList.append(path)
                return
            self.helper(nums, index+1, path.copy())
            path.append(nums[index])
            self.helper(nums, index+1,path.copy())


## Just Iterative approach without recursion
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        mainList = []
        mainList.append([])
        for i in range(len(nums)):
            size = len(mainList)
            for j in range(size):
                newList = mainList[j].copy()
                newList.append(nums[i])
                mainList.append(newList)
        return mainList

        
# Approach: Recursive

# Here we are dealing with choices every time. To choose or not to choose. If we do not choose then move the index pointer one step ahead in given array. Also if we choose to go with that number on that index then we will move index pointer. Here we will keep a copy of the list that has been formed till that point in recursion tree and it will be appended when index reaches end of the given array.

# Time complexity: Exponenetial
# Space complexity: O(N^2)

# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.result = []
        
#         if nums == None or len(nums) == 0:
#             return self.result
        
#         self.helper(nums, 0, [])
#         return self.result
    
#     def helper(self, nums, index, temp):
#         # Base: Here all paths lead to a right result so we need to return whenever that case is hit
#         if index == len(nums):
#             self.result.append(temp)
#             return
        
#         # Logic
#         # Not choosing
#         self.helper(nums, index + 1, temp.copy())
        
#         temp.append(nums[index])
#         # Choosing: In both the cases we will move on to next index
#         self.helper(nums, index + 1, temp.copy())
        
# Approach: Backtracking

# Backtracking apporach is more optimized in terms of space. Here instead of maintaining a separate list for each decision, we maintain just one array, an after we are done visiting that branch, we backtrack and visit another branch. We add a copy of the list to resultant list, because if we use a reference of the list we have been using so far then at the end the lists will be found empty, which would be a wrong solution

# Time complexity: Exponential
# Space complexity: O(n)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        
        if nums == None or len(nums) == 0:
            return self.result
        
        self.helper(nums, 0, [])
        return self.result
    
    def helper(self, nums, index, temp):
        
        self.result.append(temp.copy())
        
        for i in range(index, len(nums)):
            temp.append(nums[i])
            self.helper(nums, i + 1, temp)
            temp.pop()
            
    
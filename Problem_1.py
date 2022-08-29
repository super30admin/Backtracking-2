"""
Problem1 
Subsets (https://leetcode.com/problems/subsets/)
"""


# Approach - 1

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        """
        Using 0-1 recursion
        Time Complexity :O(2^N) N: len of nums array
        Space Complexity :O(N)
        """
        result = []
        
        def helper(nums, idx, path):
            # Base Condition
            if idx == len(nums):
                result.append(path)
                return
            
            # Logic
            # Dont choose
            helper(nums, idx + 1, list(path))
            
            # Choose
            # Adding the path
            path.append(nums[idx])
            helper(nums, idx + 1, list(path))
        
        helper(nums, 0, [])
        return result

# Approach - 2
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        """
        Changing the order of choose and not choose
        same sapce/time complexity as above
        """
        result = []
        
        def helper(nums, idx, path):
            # Base Condition
            if idx == len(nums):
                result.append(list(path))
                return
            
            # Logic
            # Choose
            # Adding the path
            # need to create a new temp list as our prev list was getting ppended twice.
            temp = list(path)
            temp.append(nums[idx])
            helper(nums, idx + 1, list(path))
            # Dont choose
            helper(nums, idx + 1, temp)
            
           
        
        helper(nums, 0, [])
        return result

# Approach - 4
class Solution:
    class Solution:
        def subsets(self, nums: List[int]) -> List[List[int]]:
            """
            0-1 backtrack solution
            same sapce/time complexity as above
        
            """
            result = []
            
            def helper(nums, idx, path):
                # Base Condition
                if idx == len(nums):
                    result.append(list(path))
                    return
                
                # Logic
                
                # Dont choose
                helper(nums, idx + 1, path)
                
                # Choose
                # Adding the path
                # Action
                path.append(nums[idx])
                # recurse
                helper(nums, idx + 1, path)
                #bactrack
                path.pop()
            
           
        
            helper(nums, 0, [])
            return result
                
        
# Approach - 5
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        """
        for loop based recursion same sapce/time complexity
        """
        result = []
        
        def helper(nums, idx, path):
            # Logic - for loop
            result.append(path)
            for i in range(idx, len(nums)):
                # creating temp value to avoid repeated values
                temp = list(path)
                temp.append(nums[i])
                # i is the one which is moving
                helper(nums, i + 1, temp)

# Approach - 6
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        """
        For loop based- backtracking time and space complexity same as above
        """
        result = []
        
        def helper(nums, idx, path):
            # Logic - for loop
            result.append(list(path))
            for i in range(idx, len(nums)):
                # creating temp value to avoid repeated values
                # Action
                path.append(nums[i])
                # i is the one which is moving
                # Recurse
                helper(nums, i + 1, path)
                # backtrack
                path.pop() 
        
        helper(nums, 0, [])
        return result
                
            
# Approach - 7 
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        """
        Using iterative approach to solve the problem. Cascading the result with temp list and adding each element 
        at a time.
        Time Complexity : O(2^N)
        Space Complexity : O(1)
        """
        result = [[]]
        
        for i in range(len(nums)):
            for j in range(len(result)):
                
                temp = result[j][:]
               
                temp.append(nums[i])
                result.append(temp)
                
        return result
        
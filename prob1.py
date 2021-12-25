# Time Complexity: O(2^n)
# Space Complexity: O(n^2) for normal recursion and O(n) for backtracking
# Did this run seccessfully on Leetcode: Yes
# Any issues faced: No
# Explain your approach:



class Solution:

    # for loop backtracking
    def subsets(self, nums):
        
        result = []
        
        
        def helper(nums, index, path):
            
            result.append(path.copy())
            
            for i in range(index, len(nums)):
                
                path.append(nums[i])
                helper(nums, i+1, path)
                path.pop()
        
        helper(nums, 0, [])
        return result


    # for loop recursion
    # def subsets(self, nums):
        
    #     result = []
        
    #     def helper(nums, index, path):
            
    #         result.append(path)
            
    #         for i in range(index, len(nums)):
                
    #             li = path.copy()
    #             li.append(nums[i])
    #             helper(nums, i+1, li)
                
        
    #     helper(nums, 0, [])
    #     return result

    # backtracking solution
    # def subsets(self, nums):
        
    #     result = []
    #     def helper(nums, index, path):

    #         # base case
    #         if index == len(nums):
    #             result.append(path.copy())
    #             return

    #         # logic
    #         # not choose
    #         helper(nums, index+1, path)

    #         # choose
    #         path.append(nums[index])
    #         helper(nums, index+1, path)
            
    #         path.pop()

        
    #     helper(nums, 0, [])
    #     return result




    # normal 0/1 recursion
    # def subsets(self, nums):

    #     result = []
    #     def helper(nums, index, path):

    #         # base case
    #         if index == len(nums):
    #             result.append(path)
    #             return

    #         # logic
    #         # not choose
    #         helper(nums, index+1, path.copy())

    #         # choose
    #         path.append(nums[index])
    #         helper(nums, index+1, path.copy())

        
    #     helper(nums, 0, [])
    #     return result
            


# Time Complexity : O(M * N * 3^L) Where L is the length of the word on M * N array
#  Space Complexity : O(L) It would be the recursive stack. 
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        if not nums:
            return []
        
        res = []
        
        #Backtracking recursive function to trace all the outcomes
        def helper (nums, index, path):
            #Logic, if the index matches the current nums length then append the path and return
            if index == len(nums):
                res.append(path.copy())
                return
            #Add all the nums in path and remove them to obtain the dersired subsetevery iteration
            path.append(nums[index])
            helper(nums, index + 1, path)
            #Backtrack
            path.pop()
            helper(nums, index + 1, path)
                
        helper(nums,0,[])
        return res
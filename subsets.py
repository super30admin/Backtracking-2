#--------Solution 1 : Backtraking------------
''' Time Complexity : O(n* 2^n)) ;  n = len of the list and O(n) to copy path to result
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []

        def helper(nums, idx, path):
            #base
            if idx == len(nums):
                self.result.append(list(path))
                return
            #logic
            #no choose
            helper(nums, idx+1, path)

            #choose
            path.append(nums[idx])
            helper(nums, idx+1, path)
            #backtrack
            path.pop()
        
        helper(nums,0,[])
        return self.result

#--------Solution 2 : Nested For loop------------
''' Time Complexity : O(n * n^2)) ;  
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result =[[]]

        for i in range(len(nums)):
            for j in range(len(result)):
                li = result[j].copy()
                li.append(nums[i])
                result.append(li)
        return result

        
        
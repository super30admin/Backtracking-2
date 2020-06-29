----------------------------------Subsets -------------------------------------
# Time Complexity : O(2^N) N is the length of the nums
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I have used iteration approach, where I am iterating over the nums array as well as result array. Once I have chossen one element ,
#I am appending the number to each element of result array. My result array contains 2^N elements.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res= [[]]
        for i in range(len(nums)):
            res += [cur+[nums[i]] for cur in res]
        return res
        
---------------------------------- Subsets -------------------------------------
# Time Complexity : O(2^N) N is the length of the s
# Space Complexity : O(N) Temp array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here in this case I used recursive approach, every time I choose a number or not choose a number. If I choose a number I am appending it to the temp array
#and calling recursive function from the next index by changing the nums array. 
       
        
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def dfs(nums, temp):
        
            res.append(temp[:])
            
            for i in range(len(nums)):
                dfs(nums[i+1:], temp+[nums[i]])
        res = []
        dfs(nums, [])
        return res
# Leetcode problem link : https://leetcode.com/problems/subsets/
# Time Complexity:    O(2^n)
# Space Complexity:   O(n) for Backtracking
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
     1. Start from the first index and add to current path. Add current path to output at every instance
     2. Call backtracking recursively starting from next index and keep updating the path
     3. For loop will iterate through all elements in the input always starting from next index and going till end

'''

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        output = []
        self.backtrack(nums,output,0,[])
        return output
    
    def backtrack(self,nums,output,index,path):
        if index > len(nums):
            return
        
        temp = [x for x in path]
        output.append(temp)
        
        for i in range(index,len(nums)):
            path.append(nums[i])
            self.backtrack(nums,output,i+1,path)
            path.pop()
        
        
            
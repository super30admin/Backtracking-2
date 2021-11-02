# // Time Complexity : O(2^n) where n is the length of the nums array 
# // Space Complexity : O(n)  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.helper(nums,[],0)
        return self.res
    
    def helper(self, nums, temp, index):
        
        self.res.append(list(temp))
        
        for i in range(index,len(nums)):
            temp.append(nums[i])
            self.helper(nums,temp,i+1)
            temp.pop()
            
    
        
      
    
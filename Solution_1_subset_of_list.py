
// Time Complexity : o(2^(n))*n where n is length of string 
//         as at every step we have two choices to choose or not
// Space Complexity : o(n)) length of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        result=[[]]
        
        for i in nums:
            v=result.copy()
            v=[j+[i] for j in v]
            result=result+v
        return result
		
		
		
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result=[]
        self.ss(nums,0,[])
        return self.result
    
    def ss(self,nums,index,path):
        
        #base
        if index==len(nums):
            val=path.copy()
            self.result.append(val)
            return #this return prevented from adding duplicates
    
        #choose
         
        #action
        path.append(nums[index])
        
        #recursion 
        #choose
        self.ss(nums,index+1,path)
        
        #backtrack
        path.pop()
        
        #not choose
        self.ss(nums,index+1,path)
        
        
        
        
        
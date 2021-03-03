"""
78. Subsets
Time Complexity - O(2**n)
Space Complexity - O(n)
Check if input list is not empty if yes then return output
Call backtracking recurssive function with paramters as list given,output list,index by default 0 and a path i.e. empty for first instance
In backtracking append path to output and start a for loop from index to len(nums)
append nums[i] to path and again call backtracking with index+1 and new path
remove last element after the recursive function ends
"""
class Solution:
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.output = []
        if nums == None or len(nums) == 0:
            return self.output
        self.backtracking(nums,self.output,0,[])
        return self.output
    
    def backtracking(self,nums,output,index,path):
        output.append(path[:])
        for i in range(index,len(nums)):
            path.append(nums[i])
            self.backtracking(nums,output,i+1,path)
            path.pop()
    
    
 

        
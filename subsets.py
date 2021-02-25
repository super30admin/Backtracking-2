#TimeComplexity:O(N power M) Not Sure 
#SpaceComplexity: O(N)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.output=[]
        self.backtracking(nums,0,[])
        return self.output
        
    def backtracking(self,nums,index,path):
        if index>len(nums):
            return
        self.output.append(path)
        for i in range(index,len(nums)): 
            self.backtracking(nums,i+1,path+[nums[i]])

            
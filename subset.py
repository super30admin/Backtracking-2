# TC - N*2^n exponential
# Sc - O(N) for call stack
class Solution:
    def __init__(self):
        self.result  = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        self.backtrack(nums,0,[])
        return self.result    


    def backtrack(self,nums, index,path):
        ## base case
        if index == len(nums):
            self.result.append(list(path))
            return


        ## logic
        # case dont pick
        self.backtrack(nums,index+1,path) 

        ## pick case
        path.append(nums[index])
        self.backtrack(nums,index+1,path)
        path.pop()   
        

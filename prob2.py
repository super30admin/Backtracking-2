# Time Complexity => O(N*x^N) Exponential
# Space Complexity => O(N)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        if(len(nums) == 0 or nums == None):
            return result
        self.helper(nums,0,[])
        return self.result
    
    def helper(self,nums,index,path):
        if(index == len(nums)):
            self.result.append(path)
            return
        
        self.helper(nums,index + 1,path.copy())
        
        path.append(nums[index])
        
        self.helper(nums,index + 1,path.copy())
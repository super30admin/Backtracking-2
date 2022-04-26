#Time Complexity: O(N*2^N)
#Space Complexity : O(N)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.output = []
        self.helper(nums,0,[])
        self.output.append([])
        return self.output
    
    def helper(self,nums,index,path):
        
        
        for i in range(index,len(nums)):
            path.append(nums[i])
            self.helper(nums,i+1,path)
            self.output.append(path.copy())
            path.pop()

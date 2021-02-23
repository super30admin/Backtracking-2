# O(N * 2^N) TIME AND O(N) SPACE WHERE N IS LEN(NUMS)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        return self.getSubsets(nums,0,[],[])
    
    def getSubsets(self,nums,index,path,output):
        if index > len(nums):
            return output
        
        output.append(path[:])
        for i in range(index,len(nums)):
            path.append(nums[i])
            self.getSubsets(nums,i+1,path,output)
            path.pop()
        return output
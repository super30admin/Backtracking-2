# Time Complexity - O(2^n)
# Space Complexity - O(2^n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        
        for i in range(len(nums)):
            size = len(result)
            for j in range(size):
                path = result[j].copy()        
                path.append(nums[i])
                result.append(path)

        return result
                


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        path = []
        self.helper(nums,0,path)
        return self.result 

    def helper(self,nums,idx,path):
        
        self.result.append(path.copy())
            
        for i in range(idx,len(nums)):
            path.append(nums[i])
            self.helper(nums,i+1,path)
            path.pop()
        
        
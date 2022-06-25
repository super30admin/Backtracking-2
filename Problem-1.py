class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums or len(nums)==0:
            return output
        output=[]
        
        self.backtracking(nums, 0, [], output)
        
        return output
    
    def backtracking(self, nums, index, path, output):
        # if index>len(nums):
        #     return 
        
        output.append(list(path))
        
        for i in range (index, len(nums)):
            path.append(nums[i])
            self.backtracking(nums, i+1, path, output)
            path.remove(path[-1])
        
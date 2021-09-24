class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        if len(nums) == 1 or nums == None:
            return [[],nums]
        self.helper(nums, 0, [])
        
        return self.result
    
    def helper(self, nums: List[int], index:int, path: List[int]):
         
        #base
        if index == len(nums):
            self.result.append(path.copy())
            #     print("result", self.result)
            return
       
        #logic
            #action
            #choose
        self.helper(nums, index+1, path)
        path.append(nums[index])
            
            #not choose
        self.helper(nums, index+1, path)
            
        
            #backtrack
        path.pop(len(path)-1)
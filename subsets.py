'''
Time Complexity -->
O(2^n)

Space Complexity -->
O(2^n)
'''
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.dfs(nums, 0, [], res)
        return res
    
    def dfs(self, nums, index, ls, res):
        if index==len(nums):
            res.append(ls[:])
            return
        
        #Two situations 
        #Take or not take
        #Not Take
        self.dfs(nums, index+1, ls, res)
        #take 
        ls.append(nums[index])
        self.dfs(nums, index+1, ls, res)
        ls.pop(-1)

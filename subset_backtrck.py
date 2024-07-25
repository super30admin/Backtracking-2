class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res=[]
        self.helper(nums, 0, [] , res)
        return res
    def helper(self, nums, idx, path, res):
        #base

        #got this cond after drawing recrsion tree of 0/1
        if idx==len(nums):
            #res.append(path)--> returns [][][] cuz ref so deep copy
            res.append(path.copy())
            return

        #backtracking
        #choose
        #action to path
        path.append(nums[idx])
        #recurse
        self.helper(nums, idx+1, path, res)
        #bacltrack
        path.pop()


        #dont choose
        self.helper(nums, idx+1, path, res)
        
        #choose/notchoose
        """
        DEEP COPY RECURSION WITHOUT BACKTRACKING

        CREATE DEEP COPY WHEN U CHOOSE
        #logic
        #to prevent all elem ref call shit
        #dont choose-0
        self.helper(nums, idx+1,path.copy(), res)
        #choose-1
        #action to path
        new_path= path.copy()
        new_path.append(nums[idx])
        self.helper(nums, idx+1, new_path, res)"""
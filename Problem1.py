class Solution:
    def __init__(self):
        self.result = []
        self.path = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.helper(nums,0,self.path, self.result)
        return self.result

    def helper(self, nums: List[int],idx:int,path: List[int],result: List[int]):
        #base case
        self.result.append(list(self.path))
        for i in range(idx,len(nums)):
            self.path.append(nums[i])
            self.helper(nums,i+1,self.path,self.result)
            self.path.pop()
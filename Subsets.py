class Solution:
  """
  Time Complexity: O(n* 2 ^n)for both recurse and backtrack.
Space Complexity:  O(n* 2 ^n) for both recurse and backtrack
  """
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if len(nums)==0 or nums == None:
            return
        self.result = []
        # self.recurse(nums,0,[]) # using recurssion
        self.backtrack(nums,0,[]) # using backtraking
        return self.result
    
    def recurse(self,nums:List[int],idx,path:List[int]):
        #base case
        if idx == len(nums):
            self.result.append(path)
            return

        # logic
        # case 0 when we don't pick
        self.recurse(nums,idx+1,[i for i in path])
        # case when we pick
        path.append(nums[idx])
        self.recurse(nums,idx+1,[i for i in path])
    def backtrack(self,nums,idx,path)  :
        # base case
        if idx == len(nums):
            self.result.append([i for i in path])
            return

        #logic
        self.backtrack(nums,idx+1,path)
        path.append(nums[idx])
        self.backtrack(nums,idx+1,path)
        #backtrack
        path.pop()


        #backtrack

        

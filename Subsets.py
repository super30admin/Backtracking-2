# TC: O(2^N)
# SC: O(N)

class Solution:
    res=[]

    def helper(self,nums,pivot,li):
        if pivot==len(nums)+1:
            return

        self.res.append(li.copy())

        for i in range(pivot,len(nums)):
            # lis=li.copy()
            li.append(nums[i])
            self.helper(nums,i+1,li)
            li.pop()

        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res=[]
        self.helper(nums,0,[])
        return self.res

        
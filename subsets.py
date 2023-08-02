#TC - O(N*2^N)
#SC - O(N)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res=[]
        a=[]
        def sub(nums,i,a,res):
            if i==len(nums):
                res.append(a)
                return
            sub(nums,i+1,a+[nums[i]],res)
            sub(nums,i+1,a,res)
            return res
        return sub(nums,0,[],[])
import copy
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res=[]
        self.helper(nums,0,[])
        return self.res

    def helper(self,nums,i,path):

        if i == len(nums):
            self.res.append(copy.deepcopy(path))

            return
        
        self.helper(nums,i+1,path)

        path.append(nums[i])
        self.helper(nums,i+1,path)
        path.pop()


        

        
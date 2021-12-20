# Sc===>O(2*n)
# tc==O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        final=[]

        self.backtrack(final,nums,[],0)

        return final

    def backtrack(self,final,nums,path,index):
        final.append(path.copy())

        for i in range(index,len(nums)):
            path.append(nums[i])
            self.backtrack(final,nums,path,i+1)
            path.pop()
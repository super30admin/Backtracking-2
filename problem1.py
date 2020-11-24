#timecomplexity
#spacecomplexity
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # using recursion
        self.result=[[]]
        #nums indeex, templist
        self.backtrack(nums,[],0)
        return self.result
        
    #backtrack
    def backtrack(self,nums,templist,index):
        if index==len(nums):
           
            return
            
        for i in range(index,len(nums)):
            templist.append(nums[i])
            temp=templist[:]
            self.result.append(temp)
            self.backtrack(nums,templist,i+1)
            templist.pop()
        
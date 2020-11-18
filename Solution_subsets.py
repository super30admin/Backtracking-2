"""
time complexity O(2^N)
space complexity O(N)

Backtrack forloop
"""


class Solution_subsets:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res=[]
        if nums is None or len(nums)==0:
            return self.res
        templist=[]
        self.backtrack(nums,templist,0)
        return self.res
    
    def backtrack(self,nums,templist,pivot):
        #base 
        temp1=copy.deepcopy(templist)
        self.res.append(temp1)
        
        #logic
        for i in range(pivot,len(nums)):
            templist.append(nums[i])  #action
            print(templist)
            self.backtrack(nums,templist,i+1) #recurse
            templist.pop() #backtrack
            
        
        
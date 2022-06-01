'''
Time Complexity: 0(2^n) 
Space Complexity: Recusrion Stack 0(n)
'''
# choose/not choose call by reference i.e. backtracking approach

class Solution:
    
    def __init__(self):
        self.resultList = []
    
    def forLoopBasedRecursion(self,nums,idx,pairList):
        
        # take snapshot of the pairList and APPEND in the resultList
        cpy_pairList = pairList[:]
        self.resultList.append(cpy_pairList)
        
        # base condition:
        if idx == len(nums):
            # out of bounds
            return 
        
        # for-loop based recursion
        for i in range(idx,len(nums)):
            
            # get the character
            pairList.append(nums[i])
            
            # recursive call
            self.forLoopBasedRecursion(nums,i+1,pairList)
            
            # backtrack
            pairList.pop()
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        self.forLoopBasedRecursion(nums,0,[])
        
        return self.resultList
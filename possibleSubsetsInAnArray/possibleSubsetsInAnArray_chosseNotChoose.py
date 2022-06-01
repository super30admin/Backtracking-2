'''
Time Complexity: 0(2^n)
Space Complexity: Recusrion Stack 0(n)
'''
# choose/not choose call by reference i.e. backtracking approach

class Solution:
    
    def __init__(self):
        self.resultList = []
    
    def chooseNotChoose(self,nums,pairList,index):
        
        # base
        # index == len(nums)
        if index == len(nums):
            # append copy of pairList
            cp_pairList = pairList[:]
            self.resultList.append(cp_pairList)
            return
        
        # logic
        
        # 1. Not choose
        self.chooseNotChoose(nums,pairList,index+1)
        
        # 2. Choose
        pairList.append(nums[index])
        self.chooseNotChoose(nums,pairList,index+1)
        
        # 3. Backtrack from the previous state
        pairList.pop()
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        self.chooseNotChoose(nums,[],0)
        
        return self.resultList
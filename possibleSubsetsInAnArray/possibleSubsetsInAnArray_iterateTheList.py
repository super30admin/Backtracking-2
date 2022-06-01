'''
Time Complexity: 0(2^n) 
Space Complexity: None
'''

class Solution:
    
    def __init__(self):
        self.resultList = [[]]
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        for i in range(0,len(nums)):
                            # this is not dynamic because its already been passed to the range func and set
            for j in range(0,len(self.resultList)):
                
                # 1. Copy from resultList
                cpyList = self.resultList[j][:]
                
                # 2. Append into the resultList
                cpyList.append(nums[i])
                
                # 3. Append the updated cpyList into the resultList
                self.resultList.append(cpyList)
        
        return self.resultList
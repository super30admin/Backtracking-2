## Problem1 
# Subsets (https://leetcode.com/problems/subsets/)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        result = [[]]
        for i in nums:
            l = len(result)
            for k in range(l):
                result.append(result[k]+[i])
                
        return result
    
    #Time Complexity: O()
    #Approach: Iterate through each number in "nums". Append each number to every previous list in "result".
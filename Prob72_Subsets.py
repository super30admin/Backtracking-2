#Time Complexity :o(n)
# Space Complexity :o(1)
# Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no , here i used cascading method

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        res = [[]] #take emty array for starting []
        for num in nums: # iterate one number in all nums
            res += [item+[num] for item in res] 
        return res
    
    
    # first 1 res is current element
    # 2 = then join previous number with 2 = 1,2
    # go on 3 = 3, 1,3, 2,3, 1,2,3
# Time Complexity : O(2**n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#0-1 solution and taking nums one by one and appending to output array based on the elements aleady present in output
class Solution:
    
    def subsets(self,nums: List[int]) -> List[List[int]]:
        out = []
        out.append([])
        print(out)
        for i in range(len(nums)):
            size = len(out)
            while size >= 1:
                new = out[size-1].copy()
                new.append(nums[i])
                out.append(new)
                size -= 1
                
        return out
#     def __init__(self):
#         self.out = []
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.helper(nums,0,[])
#         return self.out
    
#     def helper(self,nums,pos,curr):
        
#         if pos == len(nums):
#             self.out.append(curr.copy())
#             return;
#         # consider
#         curr.append(nums[pos])
#         self.helper(nums,pos+1,curr)
#         curr.pop()
#         #don't consider
#         self.helper(nums,pos+1,curr)
        
        
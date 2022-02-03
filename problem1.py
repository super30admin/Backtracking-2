#Space Complexity = O(1)
#Time Complexity = O(n)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
         output = [[]]
        
         for num in nums:
            output += [curr + [num] for curr in output]
        
         return output
'''
// Time Complexity : O(2 ^ n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        if not nums: return []

        for i in range(len(nums)):
            if i == len(nums): return 
            size = len(result)
            for l in range(size):
                new = list(result[l])
                new.append(nums[i])
                result.append(new)
            
        
        return result
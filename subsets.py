# Time Complexity O(N2^N)
# Space Complexity O(N), where n is the number of elements in the set
# Start with an empty list and recursively iterate through all the elements of the set to generate all the subsets
# Backtrack after each recursion and make a copy of the list when adding to the global output
class Solution(object):
    def __init__(self):
        self.output = []
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.backtrack(nums,0,[])
        return self.output
    def backtrack(self,nums,index,path):
        self.output.append(list(path))
        for i in range(index,len(nums)):
            path.append(nums[i])
            self.backtrack(nums,i+1,path)
            path.pop()
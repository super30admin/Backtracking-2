# S30 Problem #72 Subsets
#LeetCode #78 https://leetcode.com/problems/subsets/description/ 

# Author : Akaash Trivedi
# Time Complexity : O(2^n) number of elements in subset
# Space Complexity : O(n) max size in path is n + height of recursive stack n 
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# for loop recursion
# choose a pivot element, and iterate in for loop pivot to end
# resursive call helper and add subset (path) to result at every recursion level - builing subset
# backtrack after each recursives call to explore remaining of combination of the nums from pivot to end

class Solution:
    def __init__(self):
        self.result = []

    def subsets(self, nums: List[int]) -> List[List[int]]:
        # call helper with nums and pivot
        self.helper(nums, 0, [])
        return self.result
    
    def helper(self, nums, pivot, path):
        #base
        # return when pivot goes out of bound
        if pivot > len(nums):
            return
        #logic
        # deep copy because ref to list is stored
        self.result.append(copy.deepcopy(path))

        for i in range(pivot, len(nums)):
            # add the num to the list
            path.append(nums[i])

            #recurse
            # we have to work with i, not pivot
            self.helper(nums,i+1,path)

            #backtrack
            path.pop()

# without recursion
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]

        # i over the nums
        for i in range(len(nums)):
            #  increasing the size of the result in j for loop so have to take initial size
            size = len(result)
            # j over elements of the results
            for j in range(size):
                # create deep copy of element in the result
                # as dont want to modify the existing elements in result
                ele = copy.deepcopy(result[j])
                #ele = result[j].copy()
                ele.append(nums[i])
                result.append(ele)
        
        return result
# Time Complexity : O(n*2^n)
# Space Complexity : O(n*2^n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
# Three line explanation of solution in plain english:
"""1. We use recursion and for loop to explore all possible subsets of the given list.
2. At each step, we either include the current element in the subset or exclude it.
3. We use a backtracking approach to explore all combinations and add them to the result list."""

#Your code here along with comments explaining your approach
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # Initialize the result list with an empty subset
        res=[[]]

        def recurse(nums,pivot,path):
            #base case to check for pivot index out of bound and return from recursion stack
            if pivot==len(nums):
                return 
            #at every pivot index iterate through the nums list and recursively find all subsets
            for i in range(pivot,len(nums)):
                path.append(nums[i])
                #append the current path to result
                #using deepcopy to avoid reference issues with the path list
                res.append(copy.deepcopy(path))
                #call the recursion function to find all subsets starting from the next index
                recurse(nums,i+1,path)
                #backtrack to by removing the last element in the path to find subsets from the previous recursive stack
                path.pop()
        #recursion function to find all subsets starting from pivot index 0 and empty path
        recurse(nums,0,[])
        return res

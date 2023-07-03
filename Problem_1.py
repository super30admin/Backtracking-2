"""
Problem : 1

Time Complexity : O(2^n)
Space Complexity : O(2^n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

For loop - 
Initializing the result with empty list, start iterating nums, retreiving all the lists from result,
appending the number to the lists and appending those lists again in the result and repeating until end of input list

Backtracking Recursion - 
Initializing a pointer at the start of input list, calling the recursion function
either not choosing the number at the given pointer, and performing recursion on the remaining list,
or choosing the number at the given index and performing the recursion on the remaining list
performing backtrack operation at the end to avoid checking all possibilities

"""

# Subsets

# Approach - 1
# For loop

class Solution(object):
    def __init__(self):
        self.result=[]
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result=[]
        result.append([])
        for i in range(len(nums)):
            for j in range(len(result)):
                li=result[j][::]
                li.append(nums[i])
                result.append(li)
        return result


# Approach - 2
# Backtracking - Recursion

class Solution(object):
    def __init__(self):
        self.result=[]

    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.helper(nums,0,[])
        return self.result

    def helper(self,nums,i,path):
        # base case
        if i==len(nums):
            self.result.append(path[::])
            return
        # logic
        # not choose
        self.helper(nums,i+1,path)

        # choose
        # action
        path.append(nums[i])
        # recurse
        self.helper(nums,i+1,path)
        # backtrack
        path.pop()




# Approach - 3
# Backtracking - For loop based recursion

class Solution(object):
    def __init__(self):
        self.result=[]

    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.helper(nums,0,[])
        return self.result
    
    def helper(self,nums,pivot,path):
        # base case - No need as my for loop is already taking care of it
        # if pivot==len(nums):
        #     return

        # logic
        for i in range(pivot,len(nums)):
            # action
            path.append(nums[i])
            # recurse
            self.helper(nums,i+1,path)
            # backtrack
            path.pop()
        self.result.append(path[::])


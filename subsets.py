# Time Complexity : O(2^n), where n is the number of elements in the input list.
# Space Complexity : O(n), for recursion stack space.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Backtracking with for loop based recursion
# We will use a recursive function to generate all possible subsets of the input list.
# How the recursive function works:
# 1. We will start with an empty subset and iterate through the input list.
# 2. For each element, we will add it to the current subset and call the recursive function with the next index.
# 3. After processing the current element, we will remove it from the current subset.
# 4. At each recursive call, we will have found a valid subset, so we will add it to the result list.
import copy
class Solution:
    def subsets(self, nums):
        # Initialize an empty list to store the result
        res = []
        # Define a recursive function to generate all possible subsets
        def dfs(pivot, subset):
            for i in range(pivot, len(nums)):
                # action
                subset.append(nums[i])
                # recurse
                dfs(i+1, subset)
                # backtrack
                subset.pop()
            # Append the current subset to the result list
            res.append(copy.copy(subset))
        # Start the recursive function with an empty subset
        dfs(0, [])
        # Return the result list
        return res
    
# Approach: For loop based recursion - brute force
# Time Complexity : O(n*2^n), where n is the number of elements in the input list.
# Space Complexity : O(n*2^n), because we are creating deep copies of subset at each recursive call.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach:
# Since we are not backtracking, we will need to create a deep copy of the subset and manipulate the copy instead of the original.
# If we do not create a deep copy, we will end up modifying the original subset and not getting the desired result.
class Solution:
    def subsets(self, nums):
        # Initialize an empty list to store the result
        res = []
        # Define a recursive function to generate all possible subsets
        def dfs(pivot, subset):
            # Loop through the input list starting from the pivot index
            for i in range(pivot, len(nums)):
                # For each element, create a copy of the current subset and add the element to it
                sub = copy.copy(subset)
                sub.append(nums[i])
                # Call the recursive function with the next index
                dfs(i+1, sub)
            # Append the current subset to the result list
            res.append(subset)
        # Start the recursive function with an empty subset
        dfs(0, [])
        # Return the result list
        return res

# Backtracking
# Time Complexity : O(2^n), where n is the number of elements in the input list.
# Space Complexity : O(n), for recursion stack space.
# Did this code successfully run on Leetcode : Yes

# Approach:
# We will use a recursive function to generate all possible subsets of the input list.
# How the recursive function works:
# At each recursive call, we will have two choices:
# 1. Include the current element in the subset.
# 2. Exclude the current element from the subset.
# We will explore both choices and generate all possible subsets.
# After processing a choice, we will backtrack to explore the other choice.
# When we reach the end of the input list, we will have found a valid subset, so we will add it to the result list.
class Solution:
    def subsets(self, nums):
        res = []
        def dfs(i, subset):
            if i == len(nums):
                res.append(copy.copy(subset))
                return

            dfs(i+1, subset)

            # action
            subset.append(nums[i])
            # recurse
            dfs(i+1, subset)
            # backtrack
            subset.pop()

        dfs(0, [])
        return res
    
# Approach: DFS recursion - brute force
# Time Complexity : O(n*2^n), where n is the number of elements in the input list.
# Space Complexity : O(n*2^n), because we are creating deep copies of subset at each recursive call.
# Did this code successfully run on Leetcode : Yes
# Approach:
# This is similar to the previous approach, but we will not be using backtracking.
# Instead, we will create a deep copy of the subset and manipulate the copy instead of the original, to make sure that we do not end up passing the subset with the last element to the no choose case.

class Solution:
    def subsets(self, nums):
        res = []
        def dfs(i, subset):
            # base case
            # If we reach the end of the input list, we will have found a valid subset, so we will add it to the result list
            if i == len(nums):
                res.append(subset)
                return
            
            # choose
            # Create a copy of the subset and add the current element to it
            sub = copy.copy(subset)
            # Add the current element to the copy of the subset
            sub.append(nums[i])
            # Call the recursive function with the next index, with the copy of the subset containing the current element
            dfs(i+1, sub)

            # no choose
            # Call the recursive function with the next index, with the copy of the original subset
            dfs(i+1, copy.copy(subset))

        # Start the recursive function with an empty subset
        dfs(0, [])
        # Return the result list
        return res
    
# DFS recursion - brute force
# Time Complexity : O(n*2^n)
# Space Complexity : O(n*2^n)
# This approach is similar to the previous approach, but it uses a different order of recursion.
# It first explores the no choose case and then the choose case.
# In this case, we don't need to create a copy of the subset in order to modify it.
# But we still need to send a copy of the subset to all the recursive calls, so that we do not end up modifying the original subset.
class Solution:
    def subsets(self, nums):
        res = []
        def dfs(i, subset):
            # base case
            if i == len(nums):
                res.append(copy.copy(subset))
                return
            
            # no choose
            dfs(i+1, copy.copy(subset))

            # choose
            subset.append(nums[i])
            dfs(i+1, copy.copy(subset))

        dfs(0, [])
        return res

# Approach: Iterative
# Time Complexity : O(2^n), where n is the number of elements in the input list.
# Space Complexity : O(n), for generating copy of the subset.
# Did this code successfully run on Leetcode : Yes
# Approach:
# We will use an iterative approach to generate all possible subsets of the input list.
# How the iterative approach works:
# 1. We will start with a resultant list containing an empty subset.
# 2. For each element in the input list, we will iterate through the resultant list and create a new subset by adding the current element to each existing subset.
# 3. We will append the new subsets to the resultant list.
class Solution:
    def subsets(self, nums):
        # Initialize the result with an empty subset
        res = [[]]
        # Iterate through the input list
        for i in range(len(nums)):
            # For each element, we will iterate through the existing subsets in the result
            for j in range(len(res)):
                # Create a new subset by adding the current element to each existing subset
                # We will create a copy of the existing subset and add the current element to it
                # This is important because we do not want to modify the existing subset
                tmp = copy.copy(res[j])
                tmp.append(nums[i])
                res.append(tmp)
        # Return the result list containing all possible subsets
        return res
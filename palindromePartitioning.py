# Time Complexity : O(2^n) * O(n), for recursion and isPalindrome check
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : difficulty understanding for-loop based recursion

# Approach: For loop based recursion
# We will use a recursive function to generate all possible partitions of the input string.
# Here, the no choose case is handled by the for loop.
# If we do not want to put a partition at the current index, we will not call the recursive function.
# If we want to put a partition at the current index, we will call the recursive function with the next index.
# We will also need to check if the substring formed by including the current character is a palindrome.
# If it is a palindrome, we will add it to the current partition and call the recursive function with the next index.
# After processing the current character, we will backtrack by removing it from the current partition.
# If it is not a palindrome, we will skip it and call the recursive function with the next index.
import copy
class Solution:
    def partition(self, s: str):
        # Method to check if a string is a palindrome
        def isPalindrome(string):
            l, r = 0, len(string)-1
            while l <= r:
                if string[l] != string[r]:
                    return False
                l += 1
                r -= 1
            return True

        # Recursive function to generate all possible partitions
        # pivot: determines the starting index of the substring
        def dfs(pivot, path):
            # Loop through the input string starting from the pivot index
            for i in range(pivot, len(s)):
                # Generate the substring from the pivot to the current index
                part = s[pivot:i+1]

                # Check if the substring is a palindrome    
                if isPalindrome(part):
                    # action
                    # If it is a palindrome, we will add it to the current partition
                    path.append(part)
                    # recurse
                    # And go to the next index, with the next index as the new pivot
                    dfs(i+1, path)
                    # backtrack
                    # Remove the current partition from the current partition
                    path.pop()
            # If we have reached the end of the string, it means we have a valid partition
            # so we will append it to the result list
            if pivot == len(s):
                res.append(copy.copy(path))

        # Initialize the result list
        res = []
        # Call the recursive function with the initial values
        dfs(0, [])
        # Return the result list
        return res
    
# This approach is the same as above, but we are not using the pivot index to determine the starting index of the substring.
# Instead, we are using the for loop to iterate through the input string.
class Solution:
    def partition(self, s: str):
        # Function to check if a string is a palindrome
        def isPalindrome(string):
            l, r = 0, len(string)-1
            while l <= r:
                if string[l] != string[r]:
                    return False
                l += 1
                r -= 1
            return True

        # Recursive function to generate all possible partitions
        # substring : is the substring that we are currently processing
        def dfs(path, substring):
            # base case
            # If the substring is empty, that means there are no more characters to process, and we have a valid partition
            # so we will append it to the result list
            if len(substring) == 0:
                res.append(copy.copy(path))
                return

            # At each recursive call, we will trim the substring from the start, and pass it to the next recursive call
            # Loop through the input string starting from the pivot index
            for i in range(0, len(substring)):
                # Generate the substring from the start to the current index
                part = substring[:i+1]
                # Check if the substring is a palindrome
                if isPalindrome(part):
                    # action
                    # If it is a palindrome, we will add it to the current partition
                    path.append(part)
                    # recurse
                    # And go to the next index, with new substring starting from the next index
                    dfs(path, substring[i+1:])
                    # backtrack
                    # Remove the current partition from the current partition
                    path.pop()
        res = []
        dfs([], s)
        return res

# Time Complexity : O(2^n) * O(n), for recursion and isPalindrome check
# Space Complexity : O(n)
# Approach : DFS + Backtracking
# In this approach, we will use a recursive function to generate all possible partitions of the input string.
# At each point, we will have 2 choices:
# 1. Include the current character in the partition.
# 2. Exclude the current character from the partition.
# If we want to include the current character, we will check if the substring formed by including the current character is a palindrome.
# If it is a palindrome, we will add it to the current partition and call the recursive function with the next index.
# After processing the current character, we will backtrack by removing it from the current partition.
# If it is not a palindrome, we will skip it and call the recursive function with the next index.
# If we want to exclude the current character, we will call the recursive function with the next index.  
class Solution:
    def partition(self, s: str):
        # Function to check if a string is a palindrome
        def isPalindrome(string):
            l, r = 0, len(string)-1
            while l <= r:
                if string[l] != string[r]:
                    return False
                l += 1
                r -= 1
            return True

        # Recursive function to generate all possible partitions
        # pivot: determines the starting index of the substring
        def dfs(i, pivot, path, size):
            # base case
            # if we have reached the end of the string
            if i == len(s):
                # if the size of the current partition is equal to the length of the string, it means we have found a valid partition
                # so we will append it to the result list
                if size == len(s):
                    res.append(copy.copy(path))
                # return to avoid further processing
                return

            # no choose
            # pivot remains the same if we don't want to put a partition at the current index
            dfs(i+1, pivot, path, size)

            # choose
            # Form the substring from the pivot to the current index
            part = s[pivot:i+1]
            # Check if the substring is a palindrome
            if isPalindrome(part):
                # action
                # If it is a palindrome, we will add it to the current partition
                path.append(part)
                # recurse
                # And go to the next index, with the next index as the new pivot
                # size will be updated to include the length of the current partition
                dfs(i+1, i+1, path, size+len(part))
                # backtrack
                # Remove the current partition from the current partition
                path.pop()
        # Initialize the result list
        res = []
        # Call the recursive function with the initial values
        dfs(0, 0, [], 0)
        # Return the result list
        return res
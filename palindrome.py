# Time Complexity : O(N.2^N) where N is the size of the list of candidates
# Space Complexity : O(N.2^N) where N is the size of the recursion stack in the worst case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am creating an ans list to store the palindromic partitions.
# I am using a helper function to perform backtracking.
# The helper function takes the current path and the starting index as input.
# If the starting index is equal to the length of the string, I append the current path to the ans list.
# I iterate through the string starting from the starting index to avoid duplicates.
# For each substring, I check if it is a palindrome using the palindrome helper function.
# If it is, I append it to the current path and call the helper function recursively with the updated path and the next index.
# After the recursive call, I remove the last substring from the current path to backtrack.
# Finally, I return the ans list.

from typing import List
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        ans = []
        def backtrack(path,idx):
            if len(s) == idx:
                ans.append(path[:])
                return 
            for i in range(idx,len(s)):
                if palindrome(s,idx,i):   
                    path.append(s[idx:i+1]) 
                    backtrack(path,i+1)
                    path.pop()
        def palindrome(path,start,end):
            while start <= end:
                if s[start] != s[end]:
                    return False
                start += 1
                end -= 1
            return True
        backtrack([],0)
        return ans


        
        
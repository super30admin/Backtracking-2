# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(2^n)
# Space Complexity : Average : O(n), for recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    - use a backtracking solution to iterate through string
    - form a substring at each iteration, and recurse from the next substring
    - if each substring is palindrome, it is added to path, else moved on
    '''
    def partition(self, s: str) -> List[List[str]]:
        result = []
        def recurse(pivot, path):
            if pivot == len(s):
                result.append(copy.deepcopy(path))

            for i in range(pivot, len(s)):
                substr = s[pivot:i+1]
                if substr == substr[::-1]:
                    path.append(substr)
                    recurse(i+1, path)
                    path.pop()
        
        recurse(0, [])
        return result
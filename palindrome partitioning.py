from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def isPalindrome(s):
            return s == s[::-1]
            
        def backtrack(start, path):
            if start == len(s):
                result.append(path[:])
                return

            for end in range(start+1, len(s)+1):
                substring = s[start:end]
                if isPalindrome(substring):
                    path.append(substring)
                    backtrack(end, path)
                    path.pop()

        backtrack(0, [])
        return result
        
# Time Complexity: O(N*2^N)
# Space Complexity: O(N)
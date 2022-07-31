# Time Complexity : O(n*2^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        self.backtrack(s, result, [])
        return result

    def backtrack(self, s, result, temp):
        if temp:
            if temp[-1] != temp[-1][::-1]:
                return
            elif not s:
                result.append(temp)
                return

        for i in range(len(s)):
            self.backtrack(s[i + 1:], result, temp + [s[0:i + 1]])

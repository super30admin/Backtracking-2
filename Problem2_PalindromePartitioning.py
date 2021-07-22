# Time Complexity: O(n . 2^n), where n is the length of string
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if not s or len(s) == 0:
            return []
        self.result = []
        self.dfs(s, 0, [])
        return self.result

    def dfs(self, s: str, index: int, path: List[str]) -> None:
        # base - If index is out of bounds, append path to the result
        if index == len(s):
            self.result.append(list(path))
            return

        # logic
        for i in range(index, len(s)):
            # if the substring is a palindrome, add it to the path and continue the recursion
            if self.is_palindrome(s, index, i):
                path.append(s[index:i + 1])
                self.dfs(s, i + 1, path)
                # backtrack
                path.pop()

    def is_palindrome(self, s: str, start: int, end: int) -> bool:
        if start == end:
            return True
        while start <= end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True

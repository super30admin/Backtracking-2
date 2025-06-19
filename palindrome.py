# Time Complexity: O(2^N * N)
# Space Complexity: O(N)

class Solution:
    def partition(self, s: str) -> list[list[str]]:
        result = []
        self.backtrack(result, [], s, 0)
        return result

    def backtrack(self, result: list[list[str]], temp_list: list[str], s: str, start: int):
        if start == len(s):
            result.append(temp_list[:])
        else:
            for i in range(start, len(s)):
                if self.is_palindrome(s, start, i):
                    temp_list.append(s[start:i + 1])
                    self.backtrack(result, temp_list, s, i + 1)
                    temp_list.pop()

    def is_palindrome(self, s: str, low: int, high: int) -> bool:
        while low < high:
            if s[low] != s[high]:
                return False
            low += 1
            high -= 1
        return True

from typing import List


class Solution:
    # Approach 1: Classic Backtracking
    # TC: O(N * 2^N), SC: O(N)
    def partition(self, s: str) -> List[List[str]]:
        def isPalindrome(s: str, start: int, end: int) -> bool:
            while start <= end:
                if s[start] != s[end]:
                    return False
                start += 1
                end -= 1
            return True

        def helper(pivot: int, path: List[str]):
            if pivot == len(s):
                result.append(path[:])
                return
            for i in range(pivot, len(s)):
                if isPalindrome(s, pivot, i):
                    path.append(s[pivot : i + 1])
                    helper(i + 1, path)
                    path.pop()

        result = []
        helper(0, [])
        return result

    # Approach 2: Choose / Not Choose style
    # TC: O(N * 2^N), SC: O(N)
    def partition_choose_not_choose(self, s: str) -> List[List[str]]:
        def isPalindrome(sub: str) -> bool:
            left, right = 0, len(sub) - 1
            while left < right:
                if sub[left] != sub[right]:
                    return False
                left += 1
                right -= 1
            return True

        result = []

        def helper(pivot: int, i: int, size: int, path: List[str]):
            if i == len(s):
                if size == len(s):
                    result.append(path[:])
                return
            helper(pivot, i + 1, size, path)  # not choose
            subStr = s[pivot : i + 1]
            if isPalindrome(subStr):
                path.append(subStr)
                helper(i + 1, i + 1, size + len(subStr), path)
                path.pop()

        helper(0, 0, 0, [])
        return result


sol = Solution()
print(sol.partition("aab"))
print(sol.partition_choose_not_choose("aab"))
print(sol.partition("abba"))

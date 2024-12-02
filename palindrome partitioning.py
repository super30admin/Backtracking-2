# TC: O(n * 2^n)
# SC: O(n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def isPalindrome(s: str) -> bool:
            l, r = 0, len(s) - 1
            while l < r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            return True

        def helper(pivot: int, path: List[str]):
            if pivot == len(s):
                res.append(path[:])
                return
            
            for i in range(pivot, len(s)):
                subStr = s[pivot:i+1]
                if isPalindrome(subStr):
                    path.append(subStr)
                    helper(i+1, path)
                    path.pop()

        res = []
        helper(0, [])
        return res

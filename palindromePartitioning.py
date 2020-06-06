# Time complexity: O(N*2^N)
# Space complexity: O(N*2^N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def partition(self, s: str):
        result = []
        self.backtrack(result, s, [], 0)

        return result

    def backtrack(self, result, s, cur, l):
        if l >= len(s):
            result.append(list(cur))
            return

        for r in range(l, len(s)):
            if self.isPalindrome(s, l, r):
                if l == r:
                    cur.append(s[l])
                else:
                    cur.append(s[l:r + 1])
                self.backtrack(result, s, cur, r + 1)
                cur.pop()

    def isPalindrome(self, s, l, r):
        if l == r:
            return True
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True


r = Solution()
s = "aab"
print("All possible palindrome partitioning are:", r.partition(s))

# Time Complexity : O(n * 2^n) --> exponential.
# Space Complexity : O(n);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# for loop recursion
class Solution:
    def isPalindrome(self, s):
        start = 0
        end = len(s) - 1
        while start <= end:
            if s[start] != s[end]:
                return False
            start, end = start+1, end-1
        return True

    def helper(self, s, index, path):
        # base
        if index == len(s):
            self.result.append(path[:])
            return
        # logic
        for i in range(index, len(s)):
            curr = s[index:i+1]
            if not self.isPalindrome(curr):
                continue
            else:
                path.append(curr)
                self.helper(s, i+1, path)
                path.pop()

    def partition(self, s: str) -> list[list[str]]:
        self.result = []
        self.helper(s, 0, [])
        return self.result


print(Solution().partition('aaba'))


# 01 based recursion
# TC: O(n*2^n); SC: O(n)
# class Solution:
#     def isPalindrome(self, s):
#         start = 0
#         end = len(s) - 1
#         while start <= end:
#             if s[start] != s[end]:
#                 return False
#             start, end = start+1, end-1
#         return True
#
#     def helper(self, s, start, index, path, count):
#         # base
#         if index == len(s):
#             if count == len(s):
#                 self.result.append(path[:])
#             return
#         # logic
#         # no choose
#         self.helper(s, start, index+1, path, count)
#         curr = s[start:index+1]
#         if self.isPalindrome(curr):
#             # choose
#             path.append(curr)
#             self.helper(s, index+1, index+1, path, count + len(curr))
#             # Back-Track
#             path.pop()
#
#     def partition(self, s: str) -> list[list[str]]:
#         self.result = []
#         self.helper(s, 0, 0, [], 0)
#         return self.result
#
#
# print(Solution().partition('aaba'))

# Recusrion, Without backtracking
class Solution:
    result = []

    def partition(self, s: str):

        self.result = []
        self.helper(s, 0, path=[])
        return print(self.result)

    # Recusrion, Without backtracking

    def helper(self, s, index, path):
        if index == len(s):
            self.result.append(path)

        for i in range(index, len(s)):
            if self.isPalindrome(s, index, i):
                li = path.copy()
                # print(li,s[index : i + 1])
                li.append(s[index: i + 1])
                self.helper(s, i + 1, li)
                # path.pop(-1)

    def isPalindrome(self, s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True


if __name__ == "__main__":
    obj = Solution()
    obj.partition("aaba")

# Output = [["a","a","b","a"],["a","aba"],["aa","b","a"]]

# TC =O(n2^n).
# Space complexity : O(n2^n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

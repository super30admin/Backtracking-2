# // Time Complexity : O(N* 2^N)
# // Space Complexity : O(N)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []

        if not s:
            return self.result

        self.helper(s, 0, [])
        return self.result

    def helper(self, s, idx, path):
        # base
        if len(s) == idx:
            self.result.append(list(path))
            return
            # logic
        for i in range(idx, len(s)):
            subString = s[idx:i + 1]
            # print(subString , s)
            if self.isPalindrome(subString):
                path.append(subString)
                self.helper(s, i + 1, path)
                path.pop()
        return

    def isPalindrome(self, s):
        start = 0
        end = len(s) - 1
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True

#leetcode - 131
#Time
#Space
#with object variable
class Solution:
    def __init__(self):
        self.res = None  # global variable result
        self.temp = None  # golabl temporary variable

    def partition(self, s):
        self.res = []  # accessing class variables
        self.temp = []  # accesing class variables
        # edge case
        if len(s) == 0: return Solution.res
        self.backtrack(s, 0)
        return self.res

    def backtrack(self, s, start):
        # Base case
        if len(self.temp) > 0 and start >= len(s):
            self.res.append(self.temp[:])
        # Logic
        for i in range(start, len(s)):
            if self.isPalindrome(s[start:i + 1]):
                if start == i:
                    self.temp.append(s[i])
                else:
                    self.temp.append(s[start:i + 1])
                self.backtrack(s, i + 1)
                self.temp.pop(-1)

    def isPalindrome(self, s):
        return s == s[::-1]

#with class variables
class Solution:
    res = None  # global variable result
    temp = None  # golabl temporary variable

    def partition(self, s):
        Solution.res = []  # accessing class variables
        Solution.temp = []  # accesing class variables
        # edge case
        if len(s) == 0: return Solution.res
        self.backtrack(s, 0)
        return Solution.res

    def backtrack(self, s, start):
        # Base case
        if len(Solution.temp) > 0 and start >= len(s):
            Solution.res.append(Solution.temp[:])
        # Logic
        for i in range(start, len(s)):
            if self.isPalindrome(s[start:i + 1]):
                if start == i:
                    Solution.temp.append(s[i])
                else:
                    Solution.temp.append(s[start:i + 1])
                self.backtrack(s, i + 1)
                Solution.temp.pop(-1)

    def isPalindrome(self, s):
        return s == s[::-1]

    def isPalindrome_1(self, s, l, r): #if we pass start and ending  l= start r=i
        if l == r: return True
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True

#TC: O(n * 2^n)
#SC: O(n)

class Solution:
    def __init__(self):
        self.finalList = []
        self.tempList = []

    def __isPalindrome(self, s, fromId, toId):
        if (toId >= len(s)):
            return False

        while (fromId <= toId):
            if (s[fromId] != s[toId]):
                return False
            fromId += 1; toId -= 1
        return True

    def __backtracking(self, s, fromIndex):
        if (fromIndex == len(s)):
            self.finalList.append(list(self.tempList))
            return
        for toIndex in range(fromIndex, len(s)):
            if self.__isPalindrome(s, fromIndex, toIndex):
                self.tempList.append(s[fromIndex: toIndex + 1])
                self.__backtracking(s, toIndex + 1)
                self.tempList.pop()

    def partition(self, s):
        if (s == None or len(s) == 0):
            return self.finalList
        self.__backtracking(s, 0)
        return self.finalList
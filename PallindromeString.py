import copy


class Solution:
    result = []

    def partition(self, s: str) :
        self.result = []
        if s == None or len(s) == 0:
            return self.result
        self.helper(s, 0, [])
        return self.result

    def helper(self, s, index, path):
        # base

        if index == len(s):
            self.result.append(copy.deepcopy(path))
            return

        # logic

        for i in range(index, len(s)):
            if (self.isPall(s, index, i)):
                path.append(s[index:i + 1])

                self.helper(s, i + 1, path)
                path.pop(-1)

    def isPall(self, s, left, right):
        if left == right:
            return True

        while left < right:
            if s[left] == s[right]:
                left += 1
                right -= 1

            else:

                return False
        return True



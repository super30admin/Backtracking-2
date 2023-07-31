# Time Complexity :  O(2**n)
# Space Complexity :O(h)
# Passed on Leetcode: yes

class Solution:
    def palindrome_check(self, val):
        n = len(val)
        l = 0
        r = n - 1

        while l < r:
            if val[l] == val[r]:
                l += 1
                r -= 1
            else:
                return False
        return True

    def backtrack(self, s, pivot, path):
        if pivot == len(s):
            self.result.append(copy.deepcopy(path))
            return

        # logic
        for i in range(pivot, len(s)):
            # action
            st = s[pivot:i + 1]
            if self.palindrome_check(st):
                path.append(st)

                # recurse
                self.backtrack(s, i + 1, path)

                # backtrack
                path.pop()

    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.path = []
        self.backtrack(s, 0, self.path)
        return self.result
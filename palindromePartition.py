class Solution:
    def partition(self, s: str) -> List[List[str]]:
        # T: O(2 ** n), S: O(n)
        res = []
        part = []

        def dfs(i):
            # Base Case
            if i >= len(s):
                res.append(part.copy())
                return
            for j in range(i, len(s)):
                if self.isPali(i, j, s):
                    part.append(s[i : j + 1])
                    dfs(j + 1)  # Recursive
                    part.pop()  # Backtrack

        dfs(0)
        return res

    def isPali(self, l, r, s):
        while l <= r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True

# Time Complexity: O(N^2)
# Space Complexity: O(N)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.helper(s, 0, [])
        return self.result

    def helper(self, s, pivot, path):
        # base
        if pivot == len(s):
            self.result.append(path[:])

        # logic
        for i in range(pivot, len(s)):
            sub = s[pivot:i+1]
            rev = sub[::-1]
            if rev == sub:
                # action
                path.append(sub)
                # recurse
                self.helper(s, i+1, path)
                # backtrack
                path.pop()

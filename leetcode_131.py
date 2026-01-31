class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []

        def is_palindrome(sub):
            return sub == sub[::-1]

        def dfs(start, path):
            if start == len(s):
                res.append(path[:])
                return

            for end in range(start + 1, len(s) + 1):
                sub = s[start:end]
                if is_palindrome(sub):
                    path.append(sub)
                    dfs(end, path)
                    path.pop()  # backtrack

        dfs(0, [])
        return res
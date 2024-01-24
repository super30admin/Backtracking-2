class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def isPalindrome(sub: str) -> bool:
            return sub == sub[::-1]

        def backtrack(start: int, path: List[str]):
            if start == len(s):
                result.append(path.copy())
                return

            for end in range(start + 1, len(s) + 1):
                if isPalindrome(s[start:end]):
                    path.append(s[start:end])
                    backtrack(end, path)
                    path.pop()

        result = []
        backtrack(0, [])
        return result

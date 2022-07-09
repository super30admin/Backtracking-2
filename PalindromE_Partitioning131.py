class Solution:
    def partition(self, s: str) -> List[List[str]]:
        # Note don't change sequence
        # Time complexity = O(N*(2**N))
        # Space complexity = O(N)
        result = []
        if s == None or len(s) == 0:
            return result

        def helper(s, pivot_index, path):
            # base
            if pivot_index >= len(s):
                result.append(path.copy())
                return

            # logic
            for i in range(pivot_index, len(s)):
                substr = s[pivot_index: i + 1]
                if isPalindrome(substr):
                    # action
                    path.append(substr)
                    # recurse
                    helper(s, i + 1, path)
                    # backtrack
                    path.pop()

        def isPalindrome(s):
            start = 0
            end = len(s) - 1
            while start < end:
                if s[start] != s[end]:
                    return False
                start += 1
                end -= 1
            return True

        helper(s, 0, [])
        return result
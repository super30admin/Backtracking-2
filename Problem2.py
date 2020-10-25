class Solution:
    def partition(self, s: str) -> List[List[str]]:
        output = []
        def backtrack(start, out):
            if start >= len(s):
                output.append(list(out))
                
            for i in range(start, len(s)):
                substr = s[start:i+1]
                if substr == substr[::-1]:
                    out.append(substr)
                    backtrack(i+1, out)
                    out.pop()
        backtrack(0, [])
        return output

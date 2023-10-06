class Solution:
    def partition(self, s: str):
        self.result = []
        def backtrack(index, path):
            if index == len(s):
                self.result.append(list(path))

            for i in range(index, len(s)):
                subStr = s[index:i+1]
                if subStr == subStr[::-1]:
                    path.append(subStr)
                    backtrack(i+1, path)
                    path.pop()
        
        backtrack(0, [])
        return self.result

#TC: O(n*2^n)
#SC: O(n)
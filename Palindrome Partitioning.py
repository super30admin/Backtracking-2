class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        def panlin(x, i, j):
            while i < j:
                if x[i] != x[j]:
                    return False
                i += 1
                j -= 1
            return True
        
        n = len(s)
        
        res = []
        stack = [(s, [])]
        
        while stack:
            string, cand = stack.pop()
     
            if string == '':
                res.append(cand)
            m = len(string)
            for i in range(m):
                if panlin(string, 0, i):
                    stack.append((string[i+1:], cand + [string[:i+1]]))
        
        return res
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        def ispalin(string): #true or False
            return string[::-1]==string
        
        n = len(s)
        res = []
        def backtrack(i, sofar):
            if i>=n:
                res.append(sofar.copy())
                #print(sofar)
                return
            
            for j in range(i, n):
                if ispalin(s[i:j+1]):
                    sofar.append(s[i:j+1])
                    backtrack(j+1, sofar)
                    sofar.pop()
        backtrack(0, [])
        return res

    

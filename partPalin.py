class Solution:
    def partition(self, s: str) -> List[List[str]]:
        #TC O(n * 2^n)
        # SC O(n)
        if s is None or len(s) == 0:
            return []
        result = []
        def isPalin(s, l, r):
            while(l < r):
                if(s[l] != s[r]):
                    return False
                l +=1
                r -=1
            return True
        def backtrack( s, path):
            # print(path)
            
            #base
            if (len(s) == 0):
                cpy = list(path)
                result.append(cpy)
                return
            
            # logic
            for i in range(0, len(s)):
                if(isPalin(s,0,i)):
                    # copys = list(path)
                    path.append(s[0:i+1])
                    backtrack(s[i+1:], path)
                    path.pop()
        backtrack(s, [])
        # r = isPalin("a",0 ,0)
        # print(r)
        return result

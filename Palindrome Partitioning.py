"""
TC/SC: O(N⋅2^N)/O(N)
"""
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        n = len(s)
        def checkIfPalindrom(start,end):
            while start < end:
                if s[start] != s[end]:
                    return False
                start += 1
                end -= 1
            return True
        
        def helper(start, currList):
            if start >= n:
                res.append(list(currList))
            for end in range(start,n):
                if checkIfPalindrom(start, end):
                    currList.append(s[start:end+1])
                    helper(end+1,currList)
                    currList.pop()
        helper(0,[])
        return res
                    
                    
                
            
            

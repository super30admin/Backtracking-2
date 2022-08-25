# Time Complexity: O(n*2^n)
# Space Complexity: O(n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        if not s:
            return result
        
        def isPalindrome(s):
            start = 0
            end = len(s)-1
            while(start<end):
                if s[start]!=s[end]:
                    return False
                start += 1
                end -= 1
            return True
            
        
        def helper(s,idx,path):
            # Base
            if idx == len(s):
                result.append(list(path))
            
            #Logic
            for i in range(idx,len(s)):
                sub = s[idx:i+1]
                if isPalindrome(sub):
                    path.append(sub)
                    helper(s,i+1,path)
                    path.pop()
        
        
        helper(s,0,[])
        return result
    
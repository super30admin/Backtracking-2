# Approach - Backtracking 
# TC - exponential 
# SC - O(n)
class Solution:
    def __isPalindrome(self, s: str, l: int, r: int) -> bool:
        if l == r:
            return True
        while(l <= r):
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
            
        return True

    def __helper(self, s: str, index: int, path: List[str]):
        if index == len(s):
            self.result.append(path.copy())
            return
        
        for i in range(index, len(s)):
            if (self.__isPalindrome(s, index, i)):
                # action
                path.append(s[index:i+1])
                # recurse
                self.__helper(s, i+1, path)
                # backtrack
                path.pop(len(path) - 1)
                    
    
    def partition(self, s: str) -> List[List[str]]:
        if not s or len(s) == 0: 
            return []
        
        
        self.result = []
        self.__helper(s, 0, [])
        return self.result
    


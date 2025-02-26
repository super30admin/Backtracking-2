class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        path = []
        self.helper(s,0,path,result)
        return result

    def helper(self, s:str, pivot:int, path: List[str],result: List[str]):
        #base case
        if pivot == len(s):
            result.append(list(path))
            return
        #logic
        for i in range(pivot,len(s)):
            curr = s[pivot:i+1]
            if self.palindrome(curr,0,len(curr)-1):
                #action
                path.append(curr)
                #recurse
                self.helper(s, i+1,path,result)
                #backtrack
                path.pop()

    def palindrome(self, s: str, l: int, r:int) -> bool:
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        
        return True

# Time Complexxity :- O(2^n) it is based on when all the subsets were created 
# Space Complexity :- O(recursive stack space )

class Solution:
    mainList = []
    def partition(self, s: str) -> List[List[str]]:
        self.mainList = []
        self.helper(s, 0, [])
        return self.mainList

    def helper(self,s, index, path):
        if index == len(s):
            self.mainList.append(path.copy())
        for i in range(index, len(s)):
            if self.isPallindrome(s, index, i):
                path.append(s[index:i+1])
                self.helper(s, i+1, path)
                path.pop()
    
    def isPallindrome(self, s, left, right):
        while left<=right:
            if s[left]!= s[right]:
                return False
            left+=1
            right-=1
        return True

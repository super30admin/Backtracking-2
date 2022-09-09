# TC: O(n(2^n))
# SC : O(n)
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.result = []
        self.s = s
        self.backtrack(0,[])
        return self.result
        
        
    def backtrack(self,pivot,path):        
        #base
        if pivot == len(self.s):
            self.result.append(path[:])
            return
        
        #logic
        for i in range(pivot,len(self.s)):
            ss = self.s[pivot:i+1]  #substring
            if (self.ispalindrome(ss)):
                #action
                path.append(ss)
                #recurse
                self.backtrack(i+1,path)
                #backtrack
                path.pop()       
        
    def ispalindrome(self,ss):
        left = 0
        right = len(ss)-1
        while left<right:
            if ss[left] != ss[right]:
                return False
            left+=1
            right-=1
        return True
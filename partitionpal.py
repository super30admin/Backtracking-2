class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res=[]
        pivot= 0
        self.helper(s, pivot, [], res)
        return res
    def helper(self, s, pivot, path, res):
        #for loop recursion--> only the 1 case in 0/1 recursion-->write base
        #bactrack too

        #base
        if pivot== len(s):
            res.append(list(path))
            return

        for i in range(pivot, len(s)):
            substr= s[pivot: i+1]
            if self.isPalindrome(substr):
                #action
                path.append(substr)
                #recurse
                self.helper(s, i+1, path, res)
                #backtrack
                path.pop()
        
    def isPalindrome (self,s):
        f=0
        e=len(s)-1
        while f<=e:
            if s[f]!=s[e]:
                return False
            f+=1
            e-=1
        return True

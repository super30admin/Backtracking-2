class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result=[]
        self.helper(s,0,[])
        return self.result

    def helper(self,s,pivot,path):
        #base case
        if pivot==len(s):
            self.result.append(path[:]) #copy
            return
        for i in range(pivot,len(s)):
            curr_str=s[pivot:i+1]
            if self.isPalindrome(curr_str):
                #action
                path.append(curr_str)
                #recurse
                self.helper(s,i+1,path)
                #backtrack
                path.pop()

    def isPalindrome(self,s):
        l=0
        h=len(s)-1

        while l<h:
            if s[l]!=s[h]:
                return False
            l=l+1
            h=h-1
        return True
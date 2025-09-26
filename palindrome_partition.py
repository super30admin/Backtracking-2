def partition(self, s: str) -> List[List[str]]:
    self.result=[]
    self.helper(s,0,[])
    return self.result

def helper(self,s,pivot,path):
    if pivot==len(s):
        self.result.append(list(path))
        return

    for i in range(pivot,len(s)):
        substr=s[pivot:i+1]

        if self.ispalindrome(substr):
            path.append(substr)

            self.helper(s,i+1,path)
            path.pop()
def ispalindrome(self,substr):
    i=0
    j=len(substr)-1
    while i<j:
        if substr[i]!=substr[j]:
            return False
        i+=1
        j-=1
    return True
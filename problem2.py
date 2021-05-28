class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if s==None or len(s)==0:
            return []

        self.result = []
        self.helper(s,[],0)
        return self.result

    def helper(self,s,path,index):

        if index==len(s):
            self.result.append(list(path))
            return

        for i in range(index,len(s),1):
            subs = s[index:i+1]
            if (self.ispalindrome(s,index,i)):
                path.append(subs)
                self.helper(s,path,i+1)
                path.pop()
    def ispalindrome(self,s,start,end):
        # if start == end :
        #     return True
        while(start < end):
            if s[start]!=s[end]:
                return False
            start = start + 1
            end = end - 1
        return True









        

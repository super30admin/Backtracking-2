#Time Complexity: O(n* 2^n)
#Space Complexity: O(n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result=[]
        if s==None or len(s)==0:
            return self.result
        self.helper(s, 0, [])
        return self.result
    def helper(self, s, index, path):
        if index==len(s):
            self.result.append(path[:])
            return 
        for i in range(index, len(s)):
            sb= s[index:i+1]
            if sb==sb[::-1]:
                path.append(sb)
                self.helper(s,i+1,path)
                path.pop()
            
    
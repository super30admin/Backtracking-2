#TimeComplexity:O(N power M) Not SUre 
#SpaceComplexity: (N)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.output=[]
        self.backtracking(s,0,[])
        return self.output
    def backtracking(self,s,index,path):
        if index>=len(s):
            self.output.append(path)
            return 
        for i in range(index,len(s)):
            cur=s[index:i+1]
            if cur==cur[::-1]:
                self.backtracking(s,i+1,path+[cur])
                


        
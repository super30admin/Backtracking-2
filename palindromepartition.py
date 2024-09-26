# // Time Complexity :exponential
# // Space Complexity :(O(1)) for backtracking
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




import copy
class Solution:
    def __init__(self):
        self.result=[]
    def partition(self, s: str) -> List[List[str]]:
        self.helper(s,0,[])
        return self.result
    def helper(self,s,index,path):
        #base
        if index==len(s):
            li=copy.copy(path)
            self.result.append(li)
            return
        #logic
        for i in range(index,len(s)):
            if self.isPalindrom(s[index:i+1]):
                path.append(s[index:i+1])
                self.helper(s,i+1,path)
                path.pop(-1)
    def isPalindrom(self,string):
        print(string[::-1])
        if string==string[::-1]:
            return True
        
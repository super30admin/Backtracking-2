# Time Complexity: O(n*2^n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = list()

    def partition(self, s: str) -> List[List[str]]:
        self.backtrack(s,0,list())
        return self.result

    def backtrack(self,string,index,path):
        if index==len(string):
            self.result.append(path[:])
            # return


        for i in range(index,len(string)):
            curr = string[index:i+1]
            if self.isPal(curr) is True:
                path.append(curr)
                self.backtrack(string,i+1,path)
                path.pop()
            # else:
            #     return

    def isPal(self,string):
        for i in range(len(string)//2):
            low = i
            high = len(string) - i - 1
            if string[low]!=string[high]:
                return False
        return True
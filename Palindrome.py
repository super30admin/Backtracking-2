#Time Complexity: O(2^n)
#Space Complexity: O(n)
#Palindrome partition

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.outputList=[]
        self.helper(0,s,[])
        return self.outputList

    def helper(self, pivot ,string, path):
        if pivot==len(string):
            self.outputList.append(path[::])
            return
        for i in range(pivot, len(string)):
            temp=string[pivot:i+1]
            if temp==temp[::-1]:
                path.append(temp)
                self.helper(i+1,string, path)
                path.pop()

# Time Complexity - O(n * 2^n)
# Space Complexity - O(n)


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        path = []
        self.helper(s,0,path)
        return self.result 

    def palindrome(self,s):
        start = 0 
        end = len(s)-1 
        while start <= end :
            if s[start] != s[end] :
                return False 
            start += 1 
            end -= 1 
        return True

    def helper(self,s,index,path):

        if index == len(s) :
            self.result.append(path.copy())


        for i in range(index,len(s)):
            substring = s[index:i+1]
            if self.palindrome(substring):
                path.append(substring)
                self.helper(s,i+1,path)
                path.pop()




    


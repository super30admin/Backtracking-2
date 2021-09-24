class Solution:
    result = []
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.helper(s, 0, [])
        return self.result
    
    def helper (self, s:str, index: int, path: List[List[str]]):
        #base
       # print(self.result)
        #print(index,path)
        if index == len(s):
            #print("first if")
           # print("path == ", path)
            self.result.append(path.copy())
         
        #logic
        for i in range(index,len(s)):
         #   print("first for")
            #if it is a palindrome
            if self.isPalindrome(s[index:i+1]):
          #      print("second if  ")
                #action
                path.append(s[index:i+1])
                
                #recurse
                self.helper(s,i+1,path)
                
                #backtrack
           #     print()
                path.pop(len(path)-1)
                
    def isPalindrome(self, sr: str):
            return sr == sr[::-1]
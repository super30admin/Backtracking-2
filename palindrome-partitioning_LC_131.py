#backtracking recursion
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result=[]
        self.backtrack(s,0,[])
        return self.result

    def backtrack(self,s,index,path):
        #base
        if index==len(s):
            self.result.append(path.copy())
            return
        #logic
        for i in range(index,len(s)):
            if  self.isPalindrome(s,index,i):
                path.append(s[index:i+1])   
                self.backtrack(s,i+1,path)
                path.pop()
               

    def isPalindrome(self,s,left,right):
              
        while left < right:
            if s[left] != s[right]:
                return False
            
            left += 1
            right -= 1
            
        return True     

#for loop based recursion, every step new list
# class Solution:
#     def partition(self, s: str) -> List[List[str]]:
#         self.result=[]
#         self.backtrack(s,0,[])
#         return self.result

#     def backtrack(self,s,index,path):
#         #base
#         if index==len(s):
#             self.result.append(path)
#             return
#         #logic
#         for i in range(index,len(s)):
#             if  self.isPalindrome(s,index,i):
#                 #copy in new list so that path will be same when we return to recursion on a same level
#                 newList=path.copy()
#                 newList.append(s[index:i+1])   
#                 self.backtrack(s,i+1,newList)
               
    

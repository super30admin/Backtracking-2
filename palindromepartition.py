from typing import  List


class Solution:
   #Space:- o(h)
   #Time:-2N

   def partition(self, s: str) -> List[List[str]]:
        if not s or len(s) == 0: return List[List[int]]
        self.result = []

        def ispalindrome(left,right):
            if left == right: return True
            while(left < right):
                if s[left] != s[right]:return False
                left += 1
                right -= 1
            return True



        def backtrack(index: int, path: List[int]) -> None:
            if index == len(s):
                self.result(path.copy())
                return 
            for idx in range(index,len(s)):
                sub=s[index:idx+1]

                if ispalindrome(index,idx):
                    path.append(sub)
                    backtrack(index=index+1,path=path)
                    path.pop()


        backtrack(index=0, path=[])
        return self.result




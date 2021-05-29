from typing import  List


class Solution:
   #Space:- o(h)
   #Time:-2N



   def subsets_Nbk(self, nums: List[int]) -> List[List[int]]:

           if not nums or len(nums) == 0: return List[List[int]]
           self.result = []

           def backtrack(index: int, path: List[int]) -> None:
               # base
               if index == len(nums):
                   self.result.append(path)
                   return
               # not choose
               backtrack(index=index + 1, path=path.copy())
               # choose
               path.append(nums[index])
               backtrack(index=index + 1, path=path.copy())

           # path.pop()

           backtrack(index=0, path=[])
           return self.result

   def subsets_bk(self, nums: List[int]) -> List[List[int]]:

       if not nums or len(nums) == 0: return List[List[int]]
       self.result = []

       def backtrack(index: int, path: List[int]) -> None:
           # base
           if index == len(nums):
               self.result.append(path.copy())
               return
           # not choose
           backtrack(index=index + 1, path=path)
           # choose
           path.append(nums[index])
           backtrack(index=index + 1, path=path)
           path.pop()

       backtrack(index=0, path=[])
       return self.result

   def subsets_forLoopwBK(self, nums: List[int]) -> List[List[int]]:
       def subsets(self, nums: List[int]) -> List[List[int]]:
           if not nums or len(nums) == 0: return List[List[int]]
           self.result = []

           def backtrack(index: int, path: List[int]) -> None:

               # if index == len(nums):
               #     self.result.append(path.copy())
               #     return
               self.result.append(path.copy())
               for idx in range(index, len(nums)):
                   path.append(nums[idx])
                   backtrack(index=idx + 1, path=path)
                   path.pop()

           backtrack(index=0, path=[])
           return self.result




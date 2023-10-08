# 0/1 backtracking solution 
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result=[]
        self.backtrack(nums,0,[])
        return self.result

    def backtrack(self,nums,index,path):
        #base
        if index==len(nums):
            self.result.append(path.copy())
            return
        #logic
        #0 or not choosen case:
        self.backtrack(nums,index+1,path)
        #append
        path.append(nums[index])
        #1 or choosen value case:
        #recurse
        self.backtrack(nums,index+1,path)
        #remove
        path.pop()

# 0/1 recursion solution with each node new list
# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.result=[]
#         self.backtrack(nums,0,[])
#         return self.result

#     def backtrack(self,nums,index,path):
#         #base
#         if index==len(nums):
#             self.result.append(path)
#             return
#         #logic
#         #0 or not choosen case:
#         self.backtrack(nums,index+1,path)
#         newList=path.copy()
#         newList.append(nums[index])
#         #1 or choosen value case:
#         self.backtrack(nums,index+1,newList)
         

#for loop recursion solution with each node new list
# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.result=[]
#         self.backtrack(nums,0,[])
#         return self.result

#     def backtrack(self,nums,index,path):
#         #base
#         self.result.append(path)
#         #logic
#         for i in range(index,len(nums)):
#             newList=path.copy()
#             newList.append(nums[i])
#             self.backtrack(nums,i+1,newList)
          


#for loop backtracking solution
# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.result=[]
#         self.backtrack(nums,0,[])
#         return self.result

#     def backtrack(self,nums,index,path):
#         #base
#         self.result.append(path.copy())
#         #logic
#         for i in range(index,len(nums)):
#             #append
#             path.append(nums[i])
#             #recurse
#             self.backtrack(nums,i+1,path)
#             #backtrack
#             path.pop()


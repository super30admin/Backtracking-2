#backtracking - for loop recursion
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return [[]]
        res=[]
        def backtrack(ind,path):
            #logic
            res.append(path.copy())
            for i in range(ind,len(nums)):
                path.append(nums[i])
                backtrack(i+1,path)
                path.pop(len(path)-1)

        backtrack(0,[])
        return res


# 01 recursion
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return [[]]
        res=[]
        def recurse(ind,path):
            #base
            if ind==len(nums):
                res.append(path) 
                return   
            #logic            
            recurse(ind+1,path[:])
            path.append(nums[ind])
            recurse(ind+1,path[:])                

        recurse(0,[])
        return res


#for loop recursion w/o backtrack
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return [[]]
        res=[]
        def recurse(ind,path):
            #logic            
            res.append(path)             
            for i in range(ind,len(nums)):  
                newlist=path[:]         
                newlist.append(nums[i])
                recurse(i+1,newlist)                

        recurse(0,[])
        return res
        

     
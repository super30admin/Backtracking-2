#Time Complexity:O(exponential)
#Space Complexity:O(exponential)

#Recursion approach
class Solution:
    global result
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result=[]
        if len(nums)==0:
            return self.result
        self.helper(nums,0,[])
        return self.result
    
    def helper(self, nums:List[int], idx:int , path:List[int])->None:
        if idx==len(nums):#Base
            self.result.append(path)
            return
        self.helper(nums,idx+1,path.copy()) #Choose
        path.append(nums[idx])
        self.helper(nums,idx+1,path.copy())#Not Choose


#Backtracking approach
class Solution:
    global result
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result=[]
        if len(nums)==0:
            return self.result
        self.helper(nums,0,[])
        return self.result
    
    def helper(self, nums:List[int], idx:int , path:List[int])->None:
        if idx==len(nums):              #Base
            self.result.append(path.copy())
            return
        self.helper(nums,idx+1,path)#Choose
        path.append(nums[idx])
        self.helper(nums,idx+1,path)#Not Choose
        path.pop() #Backtrack

class Solution:
    global result
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result=[]
        if len(nums)==0:
            return self.result
        self.helper(nums,0,[])
        return self.result
    
    def helper(self, nums:List[int], idx:int , path:List[int])->None:
        self.result.append(path.copy())
        for i in range(idx,len(nums)):
            path.append(nums[i])
            self.helper(nums,i+1,path)
            path.pop()#Backtrack
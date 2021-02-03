#time: O(2^n)
#space: O(2^n)


#Recursion
class Solution:
    result=[]
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if(nums==None or len(nums)==0):
            return []
        self.result=[]
        self.helper(nums,0,[])
        
        return self.result
    
    def helper(self,nums,index,path):
        if (index==len(nums)):
            newpath=[]+path
            self.result.append(newpath)
            return
        newpath=[]+path
        self.helper(nums,index+1,newpath)
        path.append(nums[index])
        newpath=[]+path
        self.helper(nums,index+1,newpath)

        
    
        
        
       
            
        
            
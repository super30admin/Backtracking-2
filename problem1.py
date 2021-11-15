#Time O(2^n*n), space O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        #calling the helper method 
        res=[]
        
        self.helper(res,nums,[],0)
        
        return res
    
    
    def helper(self,res,nums,cur,index):
       #At each time adding elements to result array 
        res.append(cur.copy())
        
        for i in range(index,len(nums)):
            cur.append(nums[i])
            self.helper(res,nums,cur,i+1)
            cur.pop()

#Time Complexity :o(2^n)
#Space Complexity :o(2^n) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    ans=None
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if(len(nums)==0 or nums==None):
            return []
        
        self.ans=[]
        self.backtrack(nums,0,[])
        return self.ans
    
    
    def backtrack(self,nums,index,path):
        #logic
        self.ans.append(copy.deepcopy(path))
        for i in range(index,len(nums)):
            path.append(nums[i])
            self.backtrack(nums,i+1,path)
            path.pop()
        
# Time Complexity : It is O(n) since we are iterating with the list.
# Space Complexity : It is O(n) we can insert all elements in the queue if value is 1.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

from typing import List
import copy

class Solution:
     
    def subsets(self, nums: List[int]) -> List[List[int]]:        
        path = []
        result = []
        Solution.calSubSet(nums,0,path,result)     
        return result
    
    def calSubSet(nums: List[int],i : int,path: [],result:[]):
        
        listLen = len(nums) 
        if listLen == i:
            result.append(path)
            return
            
        #NotChose
        Solution.calSubSet(nums,i+1, copy.deepcopy(path),result)
        #Chose       
        path.append(nums[i]) 
        Solution.calSubSet(nums,i+1,copy.deepcopy(path),result)
        return
        #return Solution.result
   
obj = Solution()
print(obj.subsets([0]))
print(obj.subsets([1,2,3]))
print(obj.subsets([3,2,4,1]))
print(obj.subsets([0]))
# print(obj.subsets([1,2]))


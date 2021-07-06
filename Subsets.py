Subsets:
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


BackTracking Approach :
----------------------
Time:O(2^n)
Space:O(n)
class Solution:
    def subsets(self, nums):
        print(nums)
        if nums == None or len(nums) == 0:
            return []
        self.result=[]
        self.backtrack(nums,0,[])
        return self.result
    def backtrack(self,nums,index,temp):
        #base
        if index > len(nums):
            return
        #logic
        self.result.append(list(temp))#current state of the running list is added to the temp
       
        for i in range(index,len(nums)):
             #action
            temp.append(nums[i])#add nums[i] to the running list temp
            #recurse
            self.backtrack(nums,i+1,temp)
            #backtrack
            temp.pop()
                
obj = Solution()
obj.subsets([1,2,3])

Recursion Appoarch :
-------------------
Time:O(2^n)
Space:O(n)
class Solution:
    def subsets(self, nums):
        print(nums)
        if nums == None or len(nums) == 0:
            return []
        self.result=[]
        self.helper_recursion(nums,0,[])
        return self.result
    def helper_recursion(self,nums,index,temp):
        if index == len(nums):
            self.result.append(temp)
            return 
            
        self.helper_recursion(nums,index+1,list(temp))
        temp.append(nums[index])
        self.helper_recursion(nums,index+1,list(temp))
            
    
obj = Solution()
obj.subsets([1,2,3])

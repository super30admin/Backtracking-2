# Time Complexity : O(n x 2^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution1:
    result = []
    def subsets(self, nums):
        self.result = []
        if not nums:
            return self.result
        self.backtrack(nums,0,[])
        return self.result 
    
    def backtrack(self,nums,indx,temp):
        # base 
        if indx == len(nums):
            self.result.append(temp.copy())
            return 
        self.result.append(temp.copy())
        # logic 
        for i in range(indx,len(nums)):
            temp.append(nums[i])
            self.backtrack(nums,i+1,temp)
            temp.pop()
# Tc = O(n*2^n) | Sc = O(n)
# class Solution2:
#     result = []
#     def subsets(self, nums):
#         self.result = []
#         if not nums:
#             return self.result
#         self.backtrack(nums,0,[])
#         return self.result 

#     def backtrack(self,nums,indx,temp):
#         # base 
#         if indx == len(nums):
#             self.result.append(temp.copy())
#             return 

#         # logic 
#         temp.append(nums[indx])
#         self.backtrack(nums,indx+1,temp)
#         temp.pop()
#         # temp.pop()
#         #Not choose 
#         self.backtrack(nums,indx+1,temp)

# Tc = O(n * 2^n) | Sc = O(2^n)
# class Solution3:
#     result = []
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.result = []
#         if not nums:
#             return self.result
#         self.backtrack(nums,0,[])
#         return self.result 

#     def backtrack(self,nums,indx,temp):
#         # base 
#         if indx == len(nums):
#             self.result.append(temp)
#             return 

#         # logic 
#         #Not choose 
#         self.backtrack(nums,indx+1,temp)
#         # Choose
#         self.backtrack(nums,indx+1,temp+[nums[indx]])
        
if __name__ == "__main__":
    s = Solution1()
    nums = [1,2,3]
    res = s.subsets(nums)
    print(res)
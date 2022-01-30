# // Time Complexity : O(n * 2^n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # method 1
        # result = [[]]
        # for n in nums:
        #     s = len(result)
        #     for i in range(s):
        #         temp = result[i].copy()
        #         temp.append(n)
        #         result.append(temp)
        # return result
    
        # method 2
#         self.result = []
#         def helper(nums,index,path):
#             # base
#             if index == len(nums):
#                 self.result.append(path)
#                 return

#             # logic
#             temp = path.copy()
#             temp.append(nums[index])
#             choose = helper(nums,index + 1, temp)
#             notchoose = helper(nums,index+1, path.copy())
#         helper(nums,0,[])
#         return self.result

        # method 3
#         self.result = []
#         def helper(nums,index,path):
#             # base
#             if index == len(nums):
#                 self.result.append(path.copy())
#                 return

#             # logic
#             notchoose = helper(nums,index+1, path)
#             path.append(nums[index])
#             choose = helper(nums,index + 1, path)
#             path.pop()
            
#         helper(nums,0,[])
#         return self.result
        
        # method 4
        self.result = []
        def helper(nums,index,path):
            # base
            
            # logic
            self.result.append(path.copy())
            for i in range(index,len(nums)):
                path.append(nums[i])
                helper(nums,i+1,path)
                path.pop()
        helper(nums,0,[])
        return self.result

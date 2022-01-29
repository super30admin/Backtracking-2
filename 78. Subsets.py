# time complexity: O(2^n)
# space complexity: O(1)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result=[]
        if nums==None or len(nums)==0: return result
        
        def helper(nums, index, path):
            #base
            
            #logic
            result.append(list(path))
            for i in range(index, len(nums)):
                path.append(nums[i])
                # new_list=list(path)
                # new_list.append(nums[i])
                helper(nums, i+1, path)
                path.pop()
        
#         def helper(nums, index, path):
#             #base
#             if index==len(nums):
#                 result.append(list(path))
#                 return
            
#             #logic
#             #zero case
#             helper(nums, index+1, path)
            
#             #one case
#             #new_list=list(path)
#             #new_list.append(nums[index])
#             path.append(nums[index])
#             helper(nums, index+1, path)
#             path.pop()
        
        helper(nums, 0, [])
        return result
    
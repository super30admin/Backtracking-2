# time complexity is o(n*2^n), where n is the size of the input
# space complexity is o(n*2^n), where n is the size of the input
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = list()
        self.helper(nums, [], 0, result)
        return result
    def helper(self, nums, l, index, result):
        result.append(l.copy())
        for i in range(index, len(nums)):
            l.append(nums[i])
            self.helper(nums, l, i+1, result)
            l.pop()
    
    
        # result = list()
        # result.append([])
        # for i in range(len(nums)):
        #     s = len(result)
        #     for j in range(s):
        #         temp = result[j].copy()
        #         temp.append(nums[i])
        #         result.append(temp)
        # return result
    
        
#         res = list()
        
#         def bt(i, temp):
#             if(len(temp) <= len(nums)):
#                 res.append(temp.copy())
                
                
#             for j in range(i, len(nums)):
#                 temp.append(nums[j])
#                 bt(j+1, temp)
#                 temp.pop()
#         bt(0, [])
#         return res
                
        
    
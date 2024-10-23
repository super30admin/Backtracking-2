# 78. Subsets
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        def helper(i,path,nums):
            nonlocal result
            #base
            if i == len(nums):
                result.append(list(path))
                return

            #logic
            #not choose
            helper(i+1,path,nums)

            #choose
            path.append(nums[i])
            helper(i+1,path,nums)
            path.pop()
            
        
        helper(0,[],nums)
        return result


        
        
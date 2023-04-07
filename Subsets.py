# Time Complexity : 2^N
# Space Complexity : N 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]

        #recursive solution
        # def helper(i,path):
        #     if i == len(nums):
        #         result.append(list(path))
        #         return

        #     helper(i+1,path)
        #     path.append(nums[i])
        #     helper(i+1,path)
        #     path.pop()

        # helper(0,[])
        # return result

        #iterative solution

        for i in range(len(nums)):
            size = len(result)
            for j in range(size):
                temp = list(result[j])
                temp.append(nums[i])
                result.append(temp)

        return result


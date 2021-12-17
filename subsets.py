"""
Subsets (https://leetcode.com/problems/subsets/)
"""


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ###basic mentallity:
        """
        The subsets will go upto a legnth of 3
        therefore we can introduce an outer loop that goes
        upto a length of 3 that can call the backtrack function
        TC: O(n * 2^n)
        Sc: o(n)
        """

        def backtrack(first=0, curr=[]):
            ##if the combination is done
            if len(curr) == k:
                output.append(curr[:])
                return
            for i in range(first, n):
                curr.append(nums[i])
                backtrack(i + 1, curr)
                curr.pop()

        output = []
        n = len(nums)
        for k in range(n + 1):
            backtrack()
        return output
        # result=[[]]
        # # print(result)
        # for n in nums:
        #     result+=[r+[n] for r in result]
        # return result

        # result=[]
        # result.append([])
        # print(result[0])
        # for i in range(len(nums)):
        #     size=len(result)
        #     for j in range(size):
        #         ##not consider
        #         notConsider=result[i]
        #         subset=list(notConsider)
        #         ##consider
        #         subset.append(nums[i])
        #         result.append(subset)
        # print(result)
        # return result

        # result.append()

        ##merge both
#             output=[]
#             output.append([])
#             for i in range(0, len(nums)):
#                 output.append([nums[i]])
#                 for j in range(i+1, len(nums)):
#                     firstval=nums[i]
#                     secondval=nums[j]
#                     print(firstval, secondval)
#                     output.append([firstval, secondval])
#             # print(output)
#             # for num in nums:
#             #     output.append()
#             if len(nums)>2:
#                 output.append(nums)
#             return output




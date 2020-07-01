# Time Complexity : O(2^n * n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach
# 1. Suppose len of nums is 3 ([1,2,3])
# 2. The binary represenation with max len 3 range from(000 to 111)
#      Dec  Bin  Subset
#       0   000    []
#       1   001    [3]
#       2   010    [2] 
#       3   011    [2,3]
#       4   100    [1]
#       5   101    [1,3]
#       6   110    [1,2]
#       7   111    [1,2.3]
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        nums_len = len(nums)
        n = 2 ** nums_len
        res = []
        for i in range(n):
            bin_i = format(i, '#0'+str(nums_len+2)+'b').replace("0b","") # get the binary equivalent in the form of list
            curr = []
            for index, val in enumerate(bin_i):
                if "1" == val:
                    curr.append(nums[index]) # traverse the binary equivalent and add to curr list if there is 1 at bin index
            res.append(curr)
        return res
# Time complexity : O(2^n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        # if nums is empty or null, then return empty list
        if not nums:
            return res
        # adding an empty list to the result
        res.append([])
        # outer for loop if to loop over the elements in nums
        for i in range(0,len(nums)):
          # inner for loop is to loop over the elements of the result seen so far
            for j in range(0,len(res)):
                #print(res[j])
                # fetch the element of res at index j and append nums[i] to it, add this list to result
                # we do so until we reach the end of the nums array
                temp = res[j][:]
                temp.append(nums[i])
                res.append(temp)
                
        return res

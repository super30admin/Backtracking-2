# Time Complexity :O(2^n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def backtrack(self,nums,temp,result,index):
        #append copy of temp
        result.append(temp[::])
        #iterate from index starting with index = 0 to end
        for i in range(index,len(nums)):
            #action append nimber at position i
            temp.append(nums[i])
            #backtrack adding one to i with new temp
            self.backtrack(nums,temp,result,i+1)
            #pop the last number appended
            temp.pop()
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        #create result and backtrack then return result
        result = []
        self.backtrack(nums,[],result,0)
        return result
        
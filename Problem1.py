# Time Complexity :O(n*2^n) where n is len of nums
# Space Complexity : O(n) single temp list
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# with backtracking approach we add subsets of every index and increment the #index to next element. if reach the end of list we remove and got to next #element

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        if nums == None or len(nums) == None:
            return self.result
        self.backtrack(nums, [], 0)
        return self.result

    def backtrack(self, nums, temp, index):

        # base case, reach the index that is end of the list, then add whatever is in the temp to the list
        #         if index > len(nums):
        #             return
        self.result.append(list(temp))
        # logic
        for i in range(index, len(nums)):
            temp.append(nums[i])
            # since we already added i, we need to move to next element
            self.backtrack(nums, list(temp), i+1)
            temp.pop()


#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.result=[]
#         if nums == None or len(nums)== None:
#             return self.result
#         self.helper(nums,[],0)
#         return self.result

#     def helper(self,nums,temp,index):

#         # base case
#         if index == len(nums):
#             self.result.append(temp)
#             return

#         # logic
#         # dont choose
#         self.helper(nums,list(temp),index+1)
#         #  choose
#         temp.append(nums[index])

#         # why index+1 in coose??
#         self.helper(nums,list(temp),index+1)
